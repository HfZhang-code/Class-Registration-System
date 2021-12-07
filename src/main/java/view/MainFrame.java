package view;

import controller.CourseController;
import controller.LoginController;
import controller.ActionController;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {


    public MainFrame() {
        init();
    }

    private void init() {
        // initialize window frame
        this.setTitle("Register Course System");
        this.setSize(800, 600);

        //get the screen size and set the location of the interface
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screeWidth = screenSize.getWidth();
        double screeHeight = screenSize.getHeight();
        this.setLocation((int) (screeWidth - 800) / 2, (int) (screeHeight - 600) / 2);

        // common component
        JPanel cards = new JPanel(new CardLayout());
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        ActionController actionController = new ActionController();
        actionController.setCards(cards);
        actionController.setCardLayout(cardLayout);

        // login component
        LoginPanel loginPanel = new LoginPanel(actionController);
        LoginController loginController = new LoginController();
        loginPanel.setLoginController(loginController);
        cards.add(loginPanel, "login");

        // course component
        CourseController courseController = new CourseController();
        CoursePanel coursePanel = new CoursePanel(actionController, courseController);
        cards.add(coursePanel, "course");

        // default show login view
        cardLayout.show(cards, "login");

        this.add(cards);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
