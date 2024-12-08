package Lesson5.test;

import javax.swing.*;
import java.awt.*;

// Интерфейс тодорхойлох
interface StudentInfo {
    String getName();
    int getAge();
    String getGrade();
    String getPhone();
    String getSelectedSubject();
    String[] getTeachers();
    String[] getSchedule();
}

// Интерфейсийг хэрэгжүүлэх класс
class StudentInfoApp implements StudentInfo {
    private String name;
    private int age;
    private String grade;
    private String phone;
    private String selectedSubject;
    private String[] teachers;
    private String[] schedule;

    public StudentInfoApp() {
        this.teachers = new String[]{"Багш 1", "Багш 2", "Багш 3"};
        this.schedule = new String[]{
                "Даваа: Математик, Физик",
                "Мягмар: Хими, Биологи",
                "Лхагва: Түүх, Англи хэл"
        };
    }

    // Интерфейсийн методыг хэрэгжүүлэх
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGrade() {
        return grade;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getSelectedSubject() {
        return selectedSubject;
    }

    @Override
    public String[] getTeachers() {
        return teachers;
    }

    @Override
    public String[] getSchedule() {
        return schedule;
    }

    public void setStudentInfo(String name, int age, String grade, String phone, String selectedSubject) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.phone = phone;
        this.selectedSubject = selectedSubject;
    }

    // Swing интерфейсийг бий болгох
    public void createAndShowGUI() {
        // Frame үүсгэх
        JFrame frame = new JFrame("Сурагчийн мэдээлэл");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // BorderLayout ашиглах
        frame.setLayout(new BorderLayout());

        // Сурагчийн ерөнхий мэдээлэл
        JPanel studentInfoPanel = new JPanel(new GridLayout(4, 2));
        studentInfoPanel.setBorder(BorderFactory.createTitledBorder("Ерөнхий мэдээлэл"));
        studentInfoPanel.add(new JLabel("Нэр:"));
        JTextField nameField = new JTextField();
        studentInfoPanel.add(nameField);
        studentInfoPanel.add(new JLabel("Нас:"));
        JTextField ageField = new JTextField();
        studentInfoPanel.add(ageField);
        studentInfoPanel.add(new JLabel("Анги:"));
        JTextField gradeField = new JTextField();
        studentInfoPanel.add(gradeField);
        studentInfoPanel.add(new JLabel("Утас:"));
        JTextField phoneField = new JTextField();
        studentInfoPanel.add(phoneField);

        // Сонгосон хичээл
        JPanel subjectPanel = new JPanel(new FlowLayout());
        subjectPanel.setBorder(BorderFactory.createTitledBorder("Сонгосон хичээл"));
        String[] subjects = {"Математик", "Физик", "Хими", "Биологи", "Түүх"};
        JComboBox<String> subjectComboBox = new JComboBox<>(subjects);
        subjectPanel.add(subjectComboBox);

        // Багш нарын мэдээлэл
        JPanel teacherPanel = new JPanel(new GridLayout(3, 2));
        teacherPanel.setBorder(BorderFactory.createTitledBorder("Багш нарын мэдээлэл"));
        for (String teacher : getTeachers()) {
            teacherPanel.add(new JLabel(teacher + ":"));
            teacherPanel.add(new JTextField());
        }

        // Хичээлийн хуваарь
        JPanel schedulePanel = new JPanel();
        schedulePanel.setBorder(BorderFactory.createTitledBorder("Хичээлийн хуваарь"));
        schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.Y_AXIS));
        for (String classSchedule : getSchedule()) {
            schedulePanel.add(new JLabel(classSchedule ));
        }

        // Panel-уудыг Frame-д нэмэх
        frame.add(studentInfoPanel, BorderLayout.NORTH);
        frame.add(subjectPanel, BorderLayout.CENTER);
        frame.add(teacherPanel, BorderLayout.SOUTH);
        frame.add(schedulePanel, BorderLayout.EAST);

        // Оруулах товчлуур
        JButton submitButton = new JButton("Мэдээлэл оруулах");
        submitButton.addActionListener(e -> {
            setStudentInfo(
                    nameField.getText(),
                    Integer.parseInt(ageField.getText()),
                    gradeField.getText(),
                    phoneField.getText(),
                    (String) subjectComboBox.getSelectedItem()
            );
            JOptionPane.showMessageDialog(frame, "Мэдээлэл амжилттай хадгалагдлаа!");
        });
        frame.add(submitButton, BorderLayout.PAGE_END);

        // Frame-г үзүүлэх
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentInfoApp app = new StudentInfoApp();
            app.createAndShowGUI();
        });
    }
}