package s21369.mas.final_project.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import s21369.mas.final_project.DTOs.FullSchoolClassDTO;
import s21369.mas.final_project.DTOs.SchoolClassTeacherDTO;
import s21369.mas.final_project.DTOs.SubjectNameDTO;
import s21369.mas.final_project.model.Student;
import s21369.mas.final_project.repository.StudentRepository;
import s21369.mas.final_project.service.SchoolClassService;

@Controller
@RequestMapping("/classes")
@AllArgsConstructor
public class SchoolClassesController {

    private final SchoolClassService schoolClassService;

    // used as a logged in student
    private final StudentRepository studentRepository;

    @GetMapping("/available")
    public String getSchoolClasses(Model model) {
        // logged in student
        Student student = studentRepository.findDistinctFirstByFirstName("Bohdan");
        model.addAttribute("availableSchoolClassesDTO",
                schoolClassService.getAvailableClassesByStudent(student));
        model.addAttribute("signedUpSchoolClassesDTO",
                schoolClassService.getSignedUpClassesByStudent(student));
        model.addAttribute("resignedSchoolClassesDTO",
                schoolClassService.getResignedClassesByStudent(student));
        return "available-classes";
    }

    @PostMapping("/available/search")
    public String getAvailableSchoolClassesBySearch(Model model, @ModelAttribute SubjectNameDTO subjectNameDTO) {
        // logged in student
        Student student = studentRepository.findDistinctFirstByFirstName("Bohdan");
        model.addAttribute("subjectName", subjectNameDTO.getSubjectName());
        model.addAttribute("availableSchoolClassesDTO",
                schoolClassService.getAvailableClassesByStudentAndSubjectNameLike(student, subjectNameDTO.getSubjectName()));
        return "available-classes";
    }

    @GetMapping("/available/{id}")
    public String getAvailableSchoolClass(Model model, @PathVariable Long id) {
        FullSchoolClassDTO fullSchoolClassDTO = schoolClassService.getClassInfo(id);
        model.addAttribute("schoolClassId", id);
        model.addAttribute("subjectName", fullSchoolClassDTO.getSchoolClass().getSubject().getSubject());
        model.addAttribute("subjectDescription", fullSchoolClassDTO.getSchoolClass().getSubject().getDescription());
        model.addAttribute("classroomNumber", fullSchoolClassDTO.getSchoolClass().getClassroom().getNumber());
        model.addAttribute("schoolYear", fullSchoolClassDTO.getSchoolClass().getSchoolYear());
        model.addAttribute("startDate", fullSchoolClassDTO.getSchoolClass().getStartDate());
        model.addAttribute("endDate", fullSchoolClassDTO.getSchoolClass().getEndDate());
        model.addAttribute("maxClassroomCapacity", fullSchoolClassDTO.getSchoolClass().getClassroom().getMaxCapacity());
        model.addAttribute("minPassGrade", fullSchoolClassDTO.getSchoolClass().getMinPassGrade());
        model.addAttribute("teachers", fullSchoolClassDTO.getTeachers());
        model.addAttribute("classroomEquipments", fullSchoolClassDTO.getClassroomEquipments());
        return "available-class-info";
    }

    @GetMapping("/available/{id}/cancel")
    public String getSchoolClassCancellation(Model model, @PathVariable Long id) {
        return "cancellation";
    }

    @GetMapping("/available/{id}/signup")
    public String getSignUpSchoolClassStudentConfirmation(Model model, @PathVariable Long id) {
        // logged in student
        Student student = studentRepository.findDistinctFirstByFirstName("Bohdan");
        schoolClassService.addStudentSchoolClass(student, id);
        SchoolClassTeacherDTO schoolClassTeacherDTO = schoolClassService.getSchoolClassTeacherById(id);
        model.addAttribute("subjectName", schoolClassTeacherDTO.getSchoolClass().getSubject().getSubject());
        model.addAttribute("teacher", schoolClassTeacherDTO.getTeacher());
        model.addAttribute("classroomNumber", schoolClassTeacherDTO.getSchoolClass().getClassroom().getNumber());
        model.addAttribute("startDate", schoolClassTeacherDTO.getSchoolClass().getStartDate());
        return "sign-up-confirmation";
    }

    @GetMapping("/{id}")
    public String getSchoolClass(Model model, @PathVariable Long id) {
        FullSchoolClassDTO fullSchoolClassDTO = schoolClassService.getClassInfo(id);
        model.addAttribute("schoolClassId", id);
        model.addAttribute("subjectName", fullSchoolClassDTO.getSchoolClass().getSubject().getSubject());
        model.addAttribute("subjectDescription", fullSchoolClassDTO.getSchoolClass().getSubject().getDescription());
        model.addAttribute("classroomNumber", fullSchoolClassDTO.getSchoolClass().getClassroom().getNumber());
        model.addAttribute("schoolYear", fullSchoolClassDTO.getSchoolClass().getSchoolYear());
        model.addAttribute("startDate", fullSchoolClassDTO.getSchoolClass().getStartDate());
        model.addAttribute("endDate", fullSchoolClassDTO.getSchoolClass().getEndDate());
        model.addAttribute("maxClassroomCapacity", fullSchoolClassDTO.getSchoolClass().getClassroom().getMaxCapacity());
        model.addAttribute("minPassGrade", fullSchoolClassDTO.getSchoolClass().getMinPassGrade());
        model.addAttribute("teachers", fullSchoolClassDTO.getTeachers());
        model.addAttribute("classroomEquipments", fullSchoolClassDTO.getClassroomEquipments());
        return "class-info";
    }

    @GetMapping("/{id}/resign")
    public String getResignSchoolClassStudentConfirmation(Model model, @PathVariable Long id) {
        // logged in student
        Student student = studentRepository.findDistinctFirstByFirstName("Bohdan");
        schoolClassService.resignStudentSchoolClass(student, id);
        SchoolClassTeacherDTO schoolClassTeacherDTO = schoolClassService.getSchoolClassTeacherById(id);
        model.addAttribute("subjectName", schoolClassTeacherDTO.getSchoolClass().getSubject().getSubject());
        model.addAttribute("teacher", schoolClassTeacherDTO.getTeacher());
        model.addAttribute("classroomNumber", schoolClassTeacherDTO.getSchoolClass().getClassroom().getNumber());
        model.addAttribute("startDate", schoolClassTeacherDTO.getSchoolClass().getStartDate());
        return "resign-confirmation";
    }

    @GetMapping("/resigned/{id}")
    public String getResignedSchoolClass(Model model, @PathVariable Long id) {
        FullSchoolClassDTO fullSchoolClassDTO = schoolClassService.getClassInfo(id);
        model.addAttribute("schoolClassId", id);
        model.addAttribute("subjectName", fullSchoolClassDTO.getSchoolClass().getSubject().getSubject());
        model.addAttribute("subjectDescription", fullSchoolClassDTO.getSchoolClass().getSubject().getDescription());
        model.addAttribute("classroomNumber", fullSchoolClassDTO.getSchoolClass().getClassroom().getNumber());
        model.addAttribute("schoolYear", fullSchoolClassDTO.getSchoolClass().getSchoolYear());
        model.addAttribute("startDate", fullSchoolClassDTO.getSchoolClass().getStartDate());
        model.addAttribute("endDate", fullSchoolClassDTO.getSchoolClass().getEndDate());
        model.addAttribute("maxClassroomCapacity", fullSchoolClassDTO.getSchoolClass().getClassroom().getMaxCapacity());
        model.addAttribute("minPassGrade", fullSchoolClassDTO.getSchoolClass().getMinPassGrade());
        model.addAttribute("teachers", fullSchoolClassDTO.getTeachers());
        model.addAttribute("classroomEquipments", fullSchoolClassDTO.getClassroomEquipments());
        return "resigned-class-info";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        // logged in student
        Student student = studentRepository.findDistinctFirstByFirstName("Bohdan");
        model.addAttribute("profile", student);
    }

}
