package view;

import cn.hutool.core.util.StrUtil;
import controller.ActionController;
import controller.CourseController;
import service.CourseService;
import util.LoginUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class CoursePanel extends AbstractPanel {

    //use table to present the courses and interact with the users
    private Object[][] tableData;
    final String[] colName = {"Course ID", "Course Name", "Instructor", "Remaining Seats"};
    private JTable table;

    private ActionController actionController;

    private CourseController courseController;

    public CoursePanel(ActionController actionController, CourseController courseController) {
        this.actionController = actionController;
        //store the each panel in the actionController
        this.actionController.attach("course", this);
        this.courseController = courseController;
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        // load table data
        this.loadData();
        // initialize frame
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Course List");
        this.add(label, BorderLayout.NORTH);

        // initialize table
        table = new JTable(tableData, colName);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        // bottom button
        JPanel bottomPanel = new JPanel();
        JButton refreshBtn = new JButton("Refresh");
        JButton selectBtn = new JButton("select");
        bottomPanel.add(refreshBtn);
        bottomPanel.add(selectBtn);
        this.add(bottomPanel, BorderLayout.SOUTH);
        //send the request to actionListener which is actionController
        // refresh button
        refreshBtn.setActionCommand("course:refresh");
        refreshBtn.addActionListener(actionController);

        // select button
        selectBtn.setActionCommand("course:select");
        selectBtn.addActionListener(actionController);

    }

    @Override
    public void doAction(String command) {
        System.out.println("course panel do " + command + " command");
        switch (command) {
            case "refresh":
                refreshData();
                break;
            case "select":
                chooseCourse();
                break;
            default:
                break;
        }
    }

    private void chooseCourse() {
        int selectedRow = table.getSelectedRow();
        //user didn't select any row,show error msg
        if (selectedRow == -1) {
            String errMsg = "You must select one course!";
            JOptionPane.showMessageDialog(null, errMsg,
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String courseId = (String) tableData[selectedRow][0];
        String stuId = LoginUtil.getLoginUser();
        String ret = courseController.chooseCourse(stuId, courseId);

        if (StrUtil.isBlank(ret)) {
            JOptionPane.showMessageDialog(null, "success",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        } else {
            JOptionPane.showMessageDialog(null, ret,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData() throws IOException {
        this.tableData = courseController.loadCourse();
    }

    public void refreshData() {
        try {
            loadData();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(tableData, colName);

        table.setModel(defaultTableModel);
        table.updateUI();
    }

    public CourseController getCourseController() {
        return courseController;
    }

    public void setCourseController(CourseController courseController) {
        this.courseController = courseController;
    }
}
