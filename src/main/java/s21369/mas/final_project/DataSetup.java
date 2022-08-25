package s21369.mas.final_project;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import s21369.mas.final_project.model.*;
import s21369.mas.final_project.repository.*;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class DataSetup implements ApplicationRunner {

    private final TeacherRepository teacherRepository;
    private final TitleRepository titleRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ClassroomRepository classroomRepository;
    private final EquipmentRepository equipmentRepository;
    private final ClassroomEquipmentRepository classroomEquipmentRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final TeacherSchoolClassRepository teacherSchoolClassRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Title title1 = Title.builder()
                .title("b.")
                .build();
        Title title2 = Title.builder()
                .title("m.")
                .build();

        titleRepository.saveAll(List.of(title1, title2));

        Teacher t1 = Teacher.builder()
                .firstName("John")
                .lastName("Wick")
                .title(title1)
                .email("john@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(35).minusDays(76))
                .sex(SexType.MALE)
                .address("Some Address 1")
                .build();
        Teacher t2 = Teacher.builder()
                .firstName("Harold")
                .lastName("Palmer")
                .title(title1)
                .email("harold@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(27).minusDays(45))
                .sex(SexType.MALE)
                .address("Some Address 2")
                .build();
        Teacher t3 = Teacher.builder()
                .firstName("Brittney")
                .lastName("Paul")
                .title(title2)
                .email("brittney@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(31).minusDays(51))
                .sex(SexType.FEMALE)
                .address("Some Address 3")
                .build();
        Teacher t4 = Teacher.builder()
                .firstName("Parker")
                .lastName("Castillo")
                .title(title2)
                .email("parker@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(38).minusDays(176))
                .sex(SexType.MALE)
                .address("Some Address 4")
                .build();
        Teacher t5 = Teacher.builder()
                .firstName("Demetrius")
                .lastName("Chavez")
                .title(title1)
                .email("demetrius@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(30).minusDays(191))
                .sex(SexType.MALE)
                .address("Some Address 5")
                .build();
        Teacher t6 = Teacher.builder()
                .firstName("Moises")
                .lastName("Mcguire")
                .title(title1)
                .email("moises@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(29).minusDays(16))
                .sex(SexType.MALE)
                .address("Some Address 6")
                .build();
        Teacher t7 = Teacher.builder()
                .firstName("Carolyn")
                .lastName("Love")
                .title(title1)
                .email("carolyn@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(26).minusDays(93))
                .sex(SexType.FEMALE)
                .address("Some Address 7")
                .build();
        Teacher t8 = Teacher.builder()
                .firstName("Manuel")
                .lastName("Craig")
                .title(title1)
                .email("manuel@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(32).minusDays(96))
                .sex(SexType.MALE)
                .address("Some Address 8")
                .build();
        Teacher t9 = Teacher.builder()
                .firstName("Roger")
                .lastName("Stanley")
                .title(title1)
                .email("roger@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(26).minusDays(6))
                .sex(SexType.MALE)
                .address("Some Address 9")
                .build();
        Teacher t10 = Teacher.builder()
                .firstName("Esther")
                .lastName("Osborne")
                .title(title2)
                .email("esther@gmail.com")
                .phone("123456789")
                .birthDate(LocalDate.now().minusYears(34).minusDays(210))
                .sex(SexType.MALE)
                .address("Some Address 10")
                .build();

        teacherRepository.saveAll(List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));

        Student s1 = Student.builder()
                .firstName("Bohdan")
                .lastName("Kordon")
                .birthDate(LocalDate.now().minusYears(17).minusDays(129))
                .sex(SexType.MALE)
                .address("Some Address 11")
                .currentSchoolYear((byte) 10)
                .build();
        Student s2 = Student.builder()
                .firstName("Robert")
                .lastName("Blair")
                .birthDate(LocalDate.now().minusYears(15).minusDays(67))
                .sex(SexType.MALE)
                .address("Some Address 12")
                .currentSchoolYear((byte) 8)
                .build();
        Student s3 = Student.builder()
                .firstName("Allen")
                .lastName("Gutierrez")
                .birthDate(LocalDate.now().minusYears(15).minusDays(78))
                .sex(SexType.FEMALE)
                .address("Some Address 13")
                .currentSchoolYear((byte) 9)
                .build();

        studentRepository.saveAll(List.of(s1, s2, s3));

        Subject sub1 = Subject.builder()
                .subject("Math")
                .description("Mathematics is the science and study of quality, structure, space, and change. Mathematicians seek out patterns, formulate new conjectures, and establish truth by rigorous deduction from appropriately chosen axioms and definitions.")
                .build();
        Subject sub2 = Subject.builder()
                .subject("Art")
                .description("In general, subject may be thought of as the “what” in a piece of art: the topic, focus, or image. The most common subjects of art include people (portraiture), arrangements of objects (still-life), the natural world (landscape), and abstractions (non-objective).")
                .build();
        Subject sub3 = Subject.builder()
                .subject("Music")
                .description("In music, a subject is the material, usually a recognizable melody, upon which part or all of a composition is based.")
                .build();
        Subject sub4 = Subject.builder()
                .subject("History")
                .description("History is the study of life in society in the past, in all its aspect, in relation to present developments and future hopes. It is the story of man in time, an inquiry into the past based on evidence. Indeed, evidence is the raw material of history teaching and learning.")
                .build();
        Subject sub5 = Subject.builder()
                .subject("Physics")
                .description("Physics is the branch of science that deals with the structure of matter and how the fundamental constituents of the universe interact. It studies objects ranging from the very small using quantum mechanics to the entire universe using general relativity.")
                .build();
        Subject sub6 = Subject.builder()
                .subject("Biology")
                .description("This course includes a study of living organisms and vital processes. Themes that will be covered in this course include scientific skills, ecology, biochemistry, cellular processes, genetics, evolution, classification of organisms, as well as plant and human body systems.")
                .build();
        Subject sub7 = Subject.builder()
                .subject("Geography")
                .description("Geography is the study of places and the relationships between people and their environments. Geographers explore both the physical properties of Earth's surface and the human societies spread across it.")
                .build();
        Subject sub8 = Subject.builder()
                .subject("Astronomy")
                .description("Astronomy is the scientific study of the contents of the entire Universe. This course will provide the student with a study of the universe and the conditions, properties, and motions of bodies in space.")
                .build();

        subjectRepository.saveAll(List.of(sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8));

        // art classroom
        Classroom c1 = Classroom.builder()
                .floor((byte) 1)
                .number("A110")
                .maxCapacity((short) 50)
                .build();
        // physics classroom
        Classroom c2 = Classroom.builder()
                .floor((byte) 2)
                .number("B213")
                .maxCapacity((short) 40)
                .build();
        // music classroom
        Classroom c3 = Classroom.builder()
                .floor((byte) 1)
                .number("A134")
                .maxCapacity((short) 35)
                .build();
        // math classroom
        Classroom c4 = Classroom.builder()
                .floor((byte) 3)
                .number("C341")
                .maxCapacity((short) 50)
                .build();
        // history classroom
        Classroom c5 = Classroom.builder()
                .floor((byte) 1)
                .number("B145")
                .maxCapacity((short) 70)
                .build();
        // biology classroom
        Classroom c6 = Classroom.builder()
                .floor((byte) 1)
                .number("A151")
                .maxCapacity((short) 42)
                .build();

        classroomRepository.saveAll(List.of(c1, c2, c3, c4, c5, c6));

        Equipment e1 = Equipment.builder()
                .equipment("Brushes")
                .build();
        Equipment e2 = Equipment.builder()
                .equipment("Color material packs")
                .build();
        Equipment e3 = Equipment.builder()
                .equipment("Graphical tablets")
                .build();
        Equipment e4 = Equipment.builder()
                .equipment("Lab coats")
                .build();
        Equipment e5 = Equipment.builder()
                .equipment("Safety glasses")
                .build();
        Equipment e6 = Equipment.builder()
                .equipment("Guitars")
                .build();
        Equipment e7 = Equipment.builder()
                .equipment("Pianos")
                .build();
        Equipment e8 = Equipment.builder()
                .equipment("Violins")
                .build();
        Equipment e9 = Equipment.builder()
                .equipment("Science calculators")
                .build();
        Equipment e10 = Equipment.builder()
                .equipment("Highlighters")
                .build();

        equipmentRepository.saveAll(List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));

        ClassroomEquipment ce1 = ClassroomEquipment.builder()
                .classroom(c1)
                .equipment(e1)
                .quantity((byte) 30)
                .build();
        ClassroomEquipment ce2 = ClassroomEquipment.builder()
                .classroom(c1)
                .equipment(e2)
                .quantity((byte) 40)
                .build();
        ClassroomEquipment ce3 = ClassroomEquipment.builder()
                .classroom(c1)
                .equipment(e3)
                .quantity((byte) 35)
                .build();
        ClassroomEquipment ce4 = ClassroomEquipment.builder()
                .classroom(c2)
                .equipment(e4)
                .quantity((byte) 0)
                .build();
        ClassroomEquipment ce5 = ClassroomEquipment.builder()
                .classroom(c2)
                .equipment(e5)
                .quantity((byte) 0)
                .build();
        ClassroomEquipment ce6 = ClassroomEquipment.builder()
                .classroom(c3)
                .equipment(e6)
                .quantity((byte) 37)
                .build();
        ClassroomEquipment ce7 = ClassroomEquipment.builder()
                .classroom(c3)
                .equipment(e7)
                .quantity((byte) 28)
                .build();
        ClassroomEquipment ce8 = ClassroomEquipment.builder()
                .classroom(c3)
                .equipment(e8)
                .quantity((byte) 34)
                .build();
        ClassroomEquipment ce9 = ClassroomEquipment.builder()
                .classroom(c4)
                .equipment(e9)
                .quantity((byte) 40)
                .build();
        ClassroomEquipment ce10 = ClassroomEquipment.builder()
                .classroom(c4)
                .equipment(e10)
                .quantity((byte) 52)
                .build();

        classroomEquipmentRepository.saveAll(List.of(ce1, ce2, ce3, ce4, ce5, ce6, ce7, ce8, ce9, ce10));

        // art class
        SchoolClass sc1 = SchoolClass.builder()
                .classroom(c1)
                .subject(sub2)
                .schoolYear((byte) 10)
                .minPassGrade((short) 61)
                .startDate(LocalDate.now().plusMonths(3).plusDays(12))
                .endDate(null)
                .build();
        // physics class
        SchoolClass sc2 = SchoolClass.builder()
                .classroom(c2)
                .subject(sub5)
                .schoolYear((byte) 10)
                .minPassGrade((short) 61)
                .startDate(LocalDate.now().plusMonths(4).plusDays(10))
                .endDate(null)
                .build();
        // music class
        SchoolClass sc3 = SchoolClass.builder()
                .classroom(c3)
                .subject(sub3)
                .schoolYear((byte) 10)
                .minPassGrade((short) 55)
                .startDate(LocalDate.now().plusMonths(4).plusDays(10))
                .endDate(LocalDate.now().plusMonths(9).plusDays(21))
                .build();
        // math class
        SchoolClass sc4 = SchoolClass.builder()
                .classroom(c4)
                .subject(sub1)
                .schoolYear((byte) 10)
                .minPassGrade((short) 71)
                .startDate(LocalDate.now().plusMonths(5).plusDays(5))
                .endDate(null)
                .build();
        // history class
        SchoolClass sc5 = SchoolClass.builder()
                .classroom(c5)
                .subject(sub4)
                .schoolYear((byte) 10)
                .minPassGrade((short) 51)
                .startDate(LocalDate.now().plusMonths(4).plusDays(23))
                .endDate(LocalDate.now().plusMonths(9).plusDays(3))
                .build();
        // biology class
        SchoolClass sc6 = SchoolClass.builder()
                .classroom(c6)
                .subject(sub6)
                .schoolYear((byte) 10)
                .minPassGrade((short) 65)
                .startDate(LocalDate.now().plusMonths(4).plusDays(19))
                .endDate(null)
                .build();
        SchoolClass sc7 = SchoolClass.builder()
                .classroom(c2)
                .subject(sub7)
                .schoolYear((byte) 10)
                .minPassGrade((short) 51)
                .startDate(LocalDate.now().plusMonths(5).plusDays(9))
                .endDate(null)
                .build();
        SchoolClass sc8 = SchoolClass.builder()
                .classroom(c4)
                .subject(sub8)
                .schoolYear((byte) 10)
                .minPassGrade((short) 61)
                .startDate(LocalDate.now().plusMonths(3).plusDays(28))
                .endDate(LocalDate.now().plusMonths(10).plusDays(8))
                .build();

        schoolClassRepository.saveAll(List.of(sc1, sc2, sc3, sc4, sc5, sc6, sc7, sc8));

        TeacherSchoolClass tsc1 = TeacherSchoolClass.builder()
                .teacher(t1)
                .schoolClass(sc1)
                .build();
        TeacherSchoolClass tsc2 = TeacherSchoolClass.builder()
                .teacher(t2)
                .schoolClass(sc1)
                .build();
        TeacherSchoolClass tsc3 = TeacherSchoolClass.builder()
                .teacher(t3)
                .schoolClass(sc1)
                .build();
        TeacherSchoolClass tsc4 = TeacherSchoolClass.builder()
                .teacher(t4)
                .schoolClass(sc2)
                .build();
        TeacherSchoolClass tsc5 = TeacherSchoolClass.builder()
                .teacher(t5)
                .schoolClass(sc2)
                .build();
        TeacherSchoolClass tsc6 = TeacherSchoolClass.builder()
                .teacher(t6)
                .schoolClass(sc3)
                .build();
        TeacherSchoolClass tsc7 = TeacherSchoolClass.builder()
                .teacher(t7)
                .schoolClass(sc3)
                .build();
        TeacherSchoolClass tsc8 = TeacherSchoolClass.builder()
                .teacher(t8)
                .schoolClass(sc4)
                .build();
        TeacherSchoolClass tsc9 = TeacherSchoolClass.builder()
                .teacher(t9)
                .schoolClass(sc4)
                .build();
        TeacherSchoolClass tsc10 = TeacherSchoolClass.builder()
                .teacher(t10)
                .schoolClass(sc5)
                .build();
        TeacherSchoolClass tsc11 = TeacherSchoolClass.builder()
                .teacher(t2)
                .schoolClass(sc6)
                .build();
        TeacherSchoolClass tsc12 = TeacherSchoolClass.builder()
                .teacher(t8)
                .schoolClass(sc6)
                .build();
        TeacherSchoolClass tsc13 = TeacherSchoolClass.builder()
                .teacher(t2)
                .schoolClass(sc7)
                .build();
        TeacherSchoolClass tsc14 = TeacherSchoolClass.builder()
                .teacher(t7)
                .schoolClass(sc7)
                .build();
        TeacherSchoolClass tsc15 = TeacherSchoolClass.builder()
                .teacher(t6)
                .schoolClass(sc8)
                .build();
        TeacherSchoolClass tsc16 = TeacherSchoolClass.builder()
                .teacher(t4)
                .schoolClass(sc8)
                .build();

        teacherSchoolClassRepository.saveAll(List.of(tsc1, tsc2, tsc3, tsc4, tsc5, tsc6, tsc7, tsc8, tsc9, tsc10, tsc11, tsc12, tsc13, tsc14, tsc15, tsc16));

    }

}
