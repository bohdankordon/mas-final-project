package s21369.mas.final_project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s21369.mas.final_project.DTOs.EquipmentStatusDTO;
import s21369.mas.final_project.DTOs.FullSchoolClassDTO;
import s21369.mas.final_project.DTOs.SchoolClassTeacherDTO;
import s21369.mas.final_project.DTOs.SchoolClassTeachersEquipmentDTO;
import s21369.mas.final_project.model.*;
import s21369.mas.final_project.repository.ClassroomEquipmentRepository;
import s21369.mas.final_project.repository.SchoolClassRepository;
import s21369.mas.final_project.repository.StudentSchoolClassRepository;
import s21369.mas.final_project.repository.TeacherSchoolClassRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    private final StudentSchoolClassRepository studentSchoolClassRepository;
    private final TeacherSchoolClassRepository teacherSchoolClassRepository;
    private final ClassroomEquipmentRepository classroomEquipmentRepository;

    public List<SchoolClassTeachersEquipmentDTO> getAvailableClassesByStudent(Student student) {
        // get all classes of student
        List<SchoolClass> studentSchoolClasses = getSchoolClassesByStudent(student);
        // get all classes by student's current school year
        List<SchoolClass> schoolClasses = schoolClassRepository.findAllBySchoolYear(student.getCurrentSchoolYear());
        schoolClasses.removeAll(studentSchoolClasses);

        return createSchoolClassTeachersEquipmentDTO(schoolClasses);
    }

    public List<SchoolClassTeachersEquipmentDTO> getSignedUpClassesByStudent(Student student) {
        // get all classes of student
        List<SchoolClass> studentSchoolClasses = getActiveSchoolClassesByStudent(student);

        return createSchoolClassTeachersEquipmentDTO(studentSchoolClasses);
    }

    public List<SchoolClassTeachersEquipmentDTO> getResignedClassesByStudent(Student student) {
        // get all classes of student
        List<SchoolClass> studentSchoolClasses = getResignedSchoolClassesByStudent(student);

        return createSchoolClassTeachersEquipmentDTO(studentSchoolClasses);
    }

    public List<SchoolClassTeachersEquipmentDTO> getAvailableClassesByStudentAndSubjectNameLike(Student student, String subjectName) {
        // get all classes of student
        List<SchoolClass> studentSchoolClasses = getSchoolClassesByStudent(student);
        // get all classes by student's current school year and subject name
        List<SchoolClass> schoolClasses = schoolClassRepository.findAllBySchoolYearAndSubjectNameLike(student.getCurrentSchoolYear(), subjectName);
        schoolClasses.removeAll(studentSchoolClasses);

        return createSchoolClassTeachersEquipmentDTO(schoolClasses);
    }

    public FullSchoolClassDTO getClassInfo(Long id) {
        // get all info with school, teachers, equipment
        SchoolClass schoolClass = schoolClassRepository.findSchoolClassById(id);
        List<Teacher> teachers = getTeachersBySchoolClass(schoolClass);
        List<ClassroomEquipment> classroomEquipments =
                classroomEquipmentRepository.findAllByClassroom(schoolClass.getClassroom());

        return FullSchoolClassDTO.builder()
                .schoolClass(schoolClass)
                .teachers(teachers)
                .classroomEquipments(classroomEquipments)
                .build();
    }

    public SchoolClassTeacherDTO getSchoolClassTeacherById(Long id) {
        SchoolClass schoolClass = schoolClassRepository.findSchoolClassById(id);
        Teacher teacher = teacherSchoolClassRepository.findFirstBySchoolClassId(id).getTeacher();

        return SchoolClassTeacherDTO.builder()
                .schoolClass(schoolClass)
                .teacher(teacher)
                .build();
    }

    public void addStudentSchoolClass(Student student, Long idSchoolClass) {
        studentSchoolClassRepository.save(StudentSchoolClass.builder()
                .student(student)
                .schoolClass(schoolClassRepository.findSchoolClassById(idSchoolClass))
                .status(Status.ACTIVE)
                .build());
    }

    public void resignStudentSchoolClass(Student student, Long idSchoolClass) {
        // save with resigned status to later be evaluated by teacher
        StudentSchoolClass studentSchoolClass =  studentSchoolClassRepository.findByStudentAndSchoolClassId(student, idSchoolClass);
        studentSchoolClass.setStatus(Status.RESIGNED);
        studentSchoolClassRepository.save(studentSchoolClass);
    }

    // create SchoolClassTeachersEquipment DTO
    private List<SchoolClassTeachersEquipmentDTO> createSchoolClassTeachersEquipmentDTO(List<SchoolClass> schoolClasses) {
        List<SchoolClassTeachersEquipmentDTO> schoolClassTeachersEquipmentDTO = new ArrayList<>();
        for (SchoolClass schoolClass : schoolClasses) {
            List<ClassroomEquipment> classroomEquipments = classroomEquipmentRepository.findAllByClassroom(schoolClass.getClassroom());
            EquipmentStatusDTO equipmentStatus;
            // check equipment availability
            if (classroomEquipments.size() == 0) {
                equipmentStatus = EquipmentStatusDTO.NOT_NEEDED;
            } else if (classroomEquipments.stream().anyMatch(v -> v.getQuantity() > 0)) {
                equipmentStatus = EquipmentStatusDTO.PRESENT;
            } else {
                equipmentStatus = EquipmentStatusDTO.NOT_AVAILABLE;
            }
            schoolClassTeachersEquipmentDTO.add(SchoolClassTeachersEquipmentDTO.builder()
                    .schoolClass(schoolClass)
                    // get all teachers by school class
                    .teachers(getTeachersBySchoolClass(schoolClass))
                    .equipmentStatus(equipmentStatus)
                    .build());
        }

        return schoolClassTeachersEquipmentDTO;
    }

    private List<Teacher> getTeachersBySchoolClass(SchoolClass schoolClass) {
        return teacherSchoolClassRepository.findAllBySchoolClass(schoolClass)
                .stream().map(TeacherSchoolClass::getTeacher).collect(Collectors.toList());
    }

    private List<SchoolClass> getSchoolClassesByStudent(Student student) {
        List<StudentSchoolClass> studentSchoolClasses = studentSchoolClassRepository.findAllByStudent(student);
        return studentSchoolClasses.stream().map(StudentSchoolClass::getSchoolClass).collect(Collectors.toList());
    }

    private List<SchoolClass> getActiveSchoolClassesByStudent(Student student) {
        List<StudentSchoolClass> studentSchoolClasses = studentSchoolClassRepository.findAllByStudent(student);
        studentSchoolClasses = studentSchoolClasses.stream().filter(v -> v.getStatus() == Status.ACTIVE).collect(Collectors.toList());
        return studentSchoolClasses.stream().map(StudentSchoolClass::getSchoolClass).collect(Collectors.toList());
    }

    private List<SchoolClass> getResignedSchoolClassesByStudent(Student student) {
        List<StudentSchoolClass> studentSchoolClasses = studentSchoolClassRepository.findAllByStudent(student);
        studentSchoolClasses = studentSchoolClasses.stream().filter(v -> v.getStatus() == Status.RESIGNED).collect(Collectors.toList());
        return studentSchoolClasses.stream().map(StudentSchoolClass::getSchoolClass).collect(Collectors.toList());
    }

}
