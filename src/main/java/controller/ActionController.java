package controller;

import cn.hutool.core.util.StrUtil;
import view.AbstractPanel;
import cn.hutool.json.JSONObject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ActionController implements ActionListener {

    //store all the panels
    private Map<String, AbstractPanel> panelMap = new HashMap<>();

    private JPanel cards;

    private CardLayout cardLayout;

    public ActionController() {
    }


    public void attach(String panelName, AbstractPanel panel) {
        this.panelMap.put(panelName, panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String[] split = command.split(":");
        //panel where the request is from
        String source = split[0];
        String cmd = split[1];
        // get the exact panel get interacted with user
        AbstractPanel panel = panelMap.get(source);
        // execute the command
        panel.doAction(cmd);
    }
    //Switch the panel
    public void switchView(String viewName) {
        this.cardLayout.show(cards, viewName);
    }

    public Map<String, AbstractPanel> getPanelMap() {
        return panelMap;
    }

    public void setPanelMap(Map<String, AbstractPanel> panelMap) {
        this.panelMap = panelMap;
    }

    public JPanel getCards() {
        return cards;
    }

    public void setCards(JPanel cards) {
        this.cards = cards;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }
}
