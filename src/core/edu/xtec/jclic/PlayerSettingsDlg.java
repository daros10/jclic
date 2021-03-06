/*
 * File    : PlayerSettingsDlg.java
 * Created : 20-jun-2002 13:23
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2005 Francesc Busquets & Departament
 * d'Educacio de la Generalitat de Catalunya
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details (see the LICENSE file).
 */

package edu.xtec.jclic;

import edu.xtec.jclic.project.LibraryManager;
import edu.xtec.jclic.report.TCPReporter;
import edu.xtec.util.Messages;
import edu.xtec.util.Options;
import edu.xtec.util.StrUtils;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author  Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.10
 */
public class PlayerSettingsDlg extends edu.xtec.util.ExtendedJDialog {

    PlayerSettings settings;
    public boolean result;
    java.awt.Component parent;
    LibraryManager libraryManager;
    Messages msg;
    Map<String, Object> reporterOptions;
    
    /** Creates new form SettingsDlg */
    public PlayerSettingsDlg(PlayerSettings settings, java.awt.Component parent) {
        super(parent, "", true);
        this.parent=parent;
        this.settings=settings;
        msg=settings.getMessages();
        setTitle(msg.get("settings_title"));
        try{
            libraryManager=LibraryManager.getLibraryManager(settings, settings.libraryManager.getJDomElement());
        } catch(Exception ex){
            msg.showErrorWarning(this, "library_error_clone", ex);
            libraryManager=settings.libraryManager;
        }
        result=false;
        reporterOptions=new HashMap<String, Object>();
        Options.strToMap(settings.reporterParams, reporterOptions, ";", '=', false);
        initComponents();
        checkEnabled(null);
        centerOver(parent);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    javax.swing.ButtonGroup reportGroup = new javax.swing.ButtonGroup();
    javax.swing.ButtonGroup mediaGroup = new javax.swing.ButtonGroup();
    javax.swing.JTabbedPane mainPane = new javax.swing.JTabbedPane();
    javax.swing.JPanel securityPane = new javax.swing.JPanel();
    pwdCheck = new javax.swing.JCheckBox();
    javax.swing.JLabel pwdLb1 = new javax.swing.JLabel();
    pwdField1 = new javax.swing.JPasswordField(settings.password, 20);
    javax.swing.JLabel pwdLb2 = new javax.swing.JLabel();
    pwdField2 = new javax.swing.JPasswordField(settings.password, 20);
    javax.swing.JPanel generalPane = new javax.swing.JPanel();
    javax.swing.JLabel lookLb = new javax.swing.JLabel();
    lookCombo = new javax.swing.JComboBox<Object>(edu.xtec.util.LFUtil.VALUES);
    javax.swing.JLabel skinLb = new javax.swing.JLabel();
    skinCombo = new javax.swing.JComboBox<Object>(edu.xtec.jclic.skins.Skin.getSystemSkinList(false));
    javax.swing.JLabel langLb = new javax.swing.JLabel();
    langCombo = new javax.swing.JComboBox<Object>(Messages.getDescriptiveLanguageCodes(msg.getLocale()));
    javax.swing.JLabel countryLb = new javax.swing.JLabel();
    countryField = new javax.swing.JTextField();
    javax.swing.JLabel variantLb = new javax.swing.JLabel();
    variantField = new javax.swing.JTextField();
    javax.swing.JLabel browserLb = new javax.swing.JLabel();
    browserField = new javax.swing.JTextField();
    javax.swing.JPanel reportPane = new javax.swing.JPanel();
    reportChk = new javax.swing.JCheckBox();
    javax.swing.JPanel reportOptionsPanel = new javax.swing.JPanel();
    tcpBtn = new javax.swing.JRadioButton();
    javax.swing.JLabel rpAddressLb = new javax.swing.JLabel();
    rpAddressTxt = new javax.swing.JTextField();
    jdbcBtn = new javax.swing.JRadioButton();
    javax.swing.JLabel rpDriverLb = new javax.swing.JLabel();
    rpDriverTxt = new javax.swing.JTextField();
    javax.swing.JLabel rpUrlLb = new javax.swing.JLabel();
    rpUrlTxt = new javax.swing.JTextField();
    javax.swing.JLabel rpUserLb = new javax.swing.JLabel();
    rpUserTxt = new javax.swing.JTextField();
    javax.swing.JLabel rpPwdLb = new javax.swing.JLabel();
    rpPwdTxt = new javax.swing.JPasswordField();
    otherBtn = new javax.swing.JRadioButton();
    javax.swing.JLabel rpClassLb = new javax.swing.JLabel();
    rpClassTxt = new javax.swing.JTextField();
    javax.swing.JLabel rpParamsLb = new javax.swing.JLabel();
    rpParamsTxt = new javax.swing.JTextField();
    javax.swing.JPanel mediaPane = new javax.swing.JPanel();
    soundEnabledChk = new javax.swing.JCheckBox();
    javax.swing.JPanel mediaSystemPanel = new javax.swing.JPanel();
    mDefaultBtn = new javax.swing.JRadioButton();
    mJMFbtn = new javax.swing.JRadioButton();
    mQTbtn = new javax.swing.JRadioButton();
    systemSoundsChk = new javax.swing.JCheckBox();
    javax.swing.JPanel libraryPane = new javax.swing.JPanel();
    autoRunLibChk = new javax.swing.JCheckBox();
    editLibPanel = libraryManager.getLibraryPane(true, true);
    javax.swing.JPanel btPanel = new javax.swing.JPanel();
    javax.swing.JButton okButton = new javax.swing.JButton();
    javax.swing.JButton cancelButton = new javax.swing.JButton();

    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        closeDialog(evt);
      }
    });

    mainPane.setToolTipText(msg.get("settings_report_tooltip"));
    mainPane.setPreferredSize(new java.awt.Dimension(500, 400));

    securityPane.setToolTipText(msg.get("settings_security_tooltip"));
    securityPane.setLayout(new java.awt.GridBagLayout());

    pwdCheck.setSelected(settings.password!=null);
    pwdCheck.setText(msg.get("settings_password_protect"));
    pwdCheck.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pwdCheckActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    securityPane.add(pwdCheck, gridBagConstraints);

    pwdLb1.setText(msg.get("settings_new_password"));
    pwdLb1.setLabelFor(pwdField1);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    securityPane.add(pwdLb1, gridBagConstraints);

    pwdField1.setEnabled(settings.password!=null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    securityPane.add(pwdField1, gridBagConstraints);

    pwdLb2.setText(msg.get("settings_new_password_confirm"));
    pwdLb2.setLabelFor(pwdField2);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    securityPane.add(pwdLb2, gridBagConstraints);

    pwdField2.setEnabled(settings.password!=null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    securityPane.add(pwdField2, gridBagConstraints);

    mainPane.addTab(msg.get("settings_security"), new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/security.gif")), securityPane, ""); // NOI18N

    generalPane.setToolTipText(msg.get("settings_general_tooltip"));
    generalPane.setLayout(new java.awt.GridBagLayout());

    lookLb.setLabelFor(lookCombo);
    lookLb.setText(msg.get("settings_look"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(lookLb, gridBagConstraints);

    lookCombo.setSelectedItem(settings.lookAndFeel);
    lookCombo.setToolTipText(msg.get("settings_look_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(lookCombo, gridBagConstraints);

    skinLb.setLabelFor(skinCombo);
    skinLb.setText(msg.get("settings_skin"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(skinLb, gridBagConstraints);

    skinCombo.setEditable(true);
    skinCombo.setSelectedItem(settings.skin);
    skinCombo.setToolTipText(msg.get("settings_skin_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(skinCombo, gridBagConstraints);

    langLb.setLabelFor(langCombo);
    langLb.setText(msg.get("settings_language"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(langLb, gridBagConstraints);

    langCombo.setSelectedItem(Messages.getDescriptiveLanguageCode(settings.language));
    langCombo.setToolTipText(msg.get("settings_language_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(langCombo, gridBagConstraints);

    countryLb.setLabelFor(countryField);
    countryLb.setText(msg.get("settings_country"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(countryLb, gridBagConstraints);

    countryField.setText(settings.country);
    countryField.setToolTipText(msg.get("settings_country_tooltip"));
    countryField.setMinimumSize(new java.awt.Dimension(75, 21));
    countryField.setPreferredSize(new java.awt.Dimension(200, 21));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(countryField, gridBagConstraints);

    variantLb.setLabelFor(variantField);
    variantLb.setText(msg.get("settings_variant"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(variantLb, gridBagConstraints);

    variantField.setText(settings.variant);
    variantField.setToolTipText(msg.get("settings_variant_tooltip"));
    variantField.setMinimumSize(new java.awt.Dimension(75, 21));
    variantField.setPreferredSize(new java.awt.Dimension(200, 21));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(variantField, gridBagConstraints);

    browserLb.setText(msg.get("settings_browser"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(browserLb, gridBagConstraints);

    browserField.setText(settings.preferredBrowser);
    browserField.setToolTipText(msg.get("settings_browser_tooltip"));
    browserField.setMinimumSize(new java.awt.Dimension(75, 21));
    browserField.setPreferredSize(new java.awt.Dimension(200, 21));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    generalPane.add(browserField, gridBagConstraints);

    mainPane.addTab(msg.get("settings_general"), new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/settings.gif")), generalPane, ""); // NOI18N

    reportPane.setLayout(new java.awt.GridBagLayout());

    reportChk.setToolTipText(msg.get("settings_report_use_tooltip"));
    reportChk.setSelected(settings.reporterEnabled);
    reportChk.setText(msg.get("settings_report_use"));
    reportChk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        reportChkActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportPane.add(reportChk, gridBagConstraints);

    reportOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(msg.get("settings_report_type")));
    reportOptionsPanel.setLayout(new java.awt.GridBagLayout());

    reportGroup.add(tcpBtn);
    tcpBtn.setSelected(settings.reporterClass.equals("TCPReporter") && (settings.reporterParams==null || settings.reporterParams.indexOf(";")<0));
    tcpBtn.setText(msg.get("settings_report_tcp"));
    tcpBtn.setToolTipText(msg.get("settings_report_tcp_tooltip"));
    tcpBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tcpBtnActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(tcpBtn, gridBagConstraints);

    rpAddressLb.setText(msg.get("settings_report_address"));
    rpAddressLb.setLabelFor(rpAddressTxt);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 8, 3, 3);
    reportOptionsPanel.add(rpAddressLb, gridBagConstraints);

    rpAddressTxt.setText(Options.getString(reporterOptions, TCPReporter.SERVER_PATH, TCPReporter.DEFAULT_SERVER_PATH));
    rpAddressTxt.setToolTipText(msg.get("settings_report_address_tooltip"));
    rpAddressTxt.setPreferredSize(new java.awt.Dimension(80, 21));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(rpAddressTxt, gridBagConstraints);

    reportGroup.add(jdbcBtn);
    jdbcBtn.setSelected(settings.reporterClass.equals("JDBCReporter"));
    jdbcBtn.setText(msg.get("settings_report_jdbc"));
    jdbcBtn.setToolTipText(msg.get("settings_report_jdbc_tooltip"));
    jdbcBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jdbcBtnActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(jdbcBtn, gridBagConstraints);

    rpDriverLb.setText(msg.get("settings_report_driver"));
    rpDriverLb.setLabelFor(rpDriverTxt);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 8, 3, 3);
    reportOptionsPanel.add(rpDriverLb, gridBagConstraints);

    rpDriverTxt.setText(Options.getString(reporterOptions, "driver", "sun.jdbc.odbc.JdbcOdbcDriver"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(rpDriverTxt, gridBagConstraints);

    rpUrlLb.setText(msg.get("settings_report_url"));
    rpUrlLb.setLabelFor(rpUrlTxt);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 8, 3, 3);
    reportOptionsPanel.add(rpUrlLb, gridBagConstraints);

    rpUrlTxt.setText(Options.getString(reporterOptions, "url", "jdbc:odbc:JClic"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(rpUrlTxt, gridBagConstraints);

    rpUserLb.setText(msg.get("settings_report_user"));
    rpUserLb.setLabelFor(rpUserTxt);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 8, 3, 3);
    reportOptionsPanel.add(rpUserLb, gridBagConstraints);

    rpUserTxt.setText(Options.getString(reporterOptions, "system_user", null));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(rpUserTxt, gridBagConstraints);

    rpPwdLb.setText(msg.get("settings_report_pwd"));
    rpPwdLb.setLabelFor(rpPwdTxt);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 8, 3, 3);
    reportOptionsPanel.add(rpPwdLb, gridBagConstraints);

    rpPwdTxt.setText(Options.getString(reporterOptions, "system_pwd", null));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(rpPwdTxt, gridBagConstraints);

    reportGroup.add(otherBtn);
    otherBtn.setSelected(!tcpBtn.isSelected() && !jdbcBtn.isSelected());
    otherBtn.setText(msg.get("settings_report_other"));
    otherBtn.setToolTipText(msg.get("settings_report_other_tooltip"));
    otherBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        otherBtnActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(otherBtn, gridBagConstraints);

    rpClassLb.setText(msg.get("settings_report_engine"));
    rpClassLb.setLabelFor(rpClassTxt);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 8, 3, 3);
    reportOptionsPanel.add(rpClassLb, gridBagConstraints);

    rpClassTxt.setText(otherBtn.isSelected() ? settings.reporterClass : null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(rpClassTxt, gridBagConstraints);

    rpParamsLb.setText(msg.get("settings_report_params"));
    rpParamsLb.setLabelFor(rpParamsTxt);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 8, 3, 3);
    reportOptionsPanel.add(rpParamsLb, gridBagConstraints);

    rpParamsTxt.setText(otherBtn.isSelected() ? settings.reporterParams : null);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportOptionsPanel.add(rpParamsTxt, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    reportPane.add(reportOptionsPanel, gridBagConstraints);

    mainPane.addTab(msg.get("settings_reports"), new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/report_small.gif")), reportPane, ""); // NOI18N

    mediaPane.setToolTipText(msg.get("settings_media_tooltip"));
    mediaPane.setLayout(new java.awt.GridBagLayout());

    soundEnabledChk.setSelected(settings.soundEnabled);
    soundEnabledChk.setText(msg.get("settings_media_enabled"));
    soundEnabledChk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        soundEnabledChkActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mediaPane.add(soundEnabledChk, gridBagConstraints);

    mediaSystemPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(msg.get("settings_media_system")));
    mediaSystemPanel.setLayout(new java.awt.GridBagLayout());

    mediaGroup.add(mDefaultBtn);
    mDefaultBtn.setSelected(edu.xtec.jclic.Constants.DEFAULT.equals(settings.mediaSystem));
    mDefaultBtn.setText(msg.get("settings_media_default"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
    mediaSystemPanel.add(mDefaultBtn, gridBagConstraints);

    mediaGroup.add(mJMFbtn);
    mJMFbtn.setSelected(edu.xtec.jclic.Constants.JMF.equals(settings.mediaSystem));
    mJMFbtn.setText(msg.get("settings_media_jmf"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
    mediaSystemPanel.add(mJMFbtn, gridBagConstraints);

    mediaGroup.add(mQTbtn);
    mQTbtn.setSelected(edu.xtec.jclic.Constants.QT.equals(settings.mediaSystem));
    mQTbtn.setText(msg.get("settings_media_qt"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
    mediaSystemPanel.add(mQTbtn, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mediaPane.add(mediaSystemPanel, gridBagConstraints);

    systemSoundsChk.setSelected(settings.systemSounds);
    systemSoundsChk.setText(msg.get("settings_media_event_sounds"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mediaPane.add(systemSoundsChk, gridBagConstraints);

    mainPane.addTab(msg.get("settings_media"), new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/audio_on.gif")), mediaPane, ""); // NOI18N

    libraryPane.setToolTipText(msg.get("settings_library_tooltip"));
    libraryPane.setLayout(new java.awt.GridBagLayout());

    autoRunLibChk.setSelected(libraryManager.autoRun);
    autoRunLibChk.setText(msg.get("settings_library_autorun"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    libraryPane.add(autoRunLibChk, gridBagConstraints);

    editLibPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(msg.get("settings_library")));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    libraryPane.add(editLibPanel, gridBagConstraints);

    mainPane.addTab(msg.get("settings_library"), new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/database.gif")), libraryPane, ""); // NOI18N

    getContentPane().add(mainPane, java.awt.BorderLayout.CENTER);

    okButton.setText(msg.get("OK"));
    okButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        okButtonActionPerformed(evt);
      }
    });
    btPanel.add(okButton);

    cancelButton.setText(msg.get("CANCEL"));
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });
    btPanel.add(cancelButton);

    getContentPane().add(btPanel, java.awt.BorderLayout.SOUTH);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void soundEnabledChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundEnabledChkActionPerformed

        checkEnabled(soundEnabledChk);
        
    }//GEN-LAST:event_soundEnabledChkActionPerformed

    private void otherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherBtnActionPerformed

        checkEnabled(reportChk);
        
    }//GEN-LAST:event_otherBtnActionPerformed

    private void jdbcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdbcBtnActionPerformed
        
        checkEnabled(reportChk);

    }//GEN-LAST:event_jdbcBtnActionPerformed

    private void tcpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpBtnActionPerformed
        
        checkEnabled(reportChk);
        
    }//GEN-LAST:event_tcpBtnActionPerformed

    private void reportChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportChkActionPerformed

        checkEnabled(reportChk);
        
    }//GEN-LAST:event_reportChkActionPerformed

    private void pwdCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdCheckActionPerformed

        checkEnabled(pwdCheck);

    }//GEN-LAST:event_pwdCheckActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed

        result=false;
        closeDialog(null);
        
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        if(accept()){
            result=true;
            closeDialog(null);
        }
                
        // Add your handling code here:
    }//GEN-LAST:event_okButtonActionPerformed

    public boolean accept(){
        String p1=null;
        if(pwdCheck.isSelected()){
            p1=StrUtils.nullableString(String.copyValueOf(pwdField1.getPassword()));
            String p2=StrUtils.nullableString(String.copyValueOf(pwdField2.getPassword()));
            if(p1==null || p2==null || !p1.equals(p2)){
                msg.showAlert(this, "PASSWORD_INCORRECT");
                return false;
            }
        }
        else
            settings.password=null;
        
        if(tcpBtn.isSelected()){
            String server=rpAddressTxt.getText();
            if(server==null || server.length()<1){
                msg.showAlert(this, "settings_report_err_server");
                return false;
            }
            settings.reporterClass="TCPReporter";
            settings.reporterParams=new StringBuilder(TCPReporter.SERVER_PATH)
                    .append("=").append(server).substring(0);
        }
        else if(jdbcBtn.isSelected()){
            String driver=StrUtils.nullableString(rpDriverTxt.getText());
            String url=StrUtils.nullableString(rpUrlTxt.getText());
            String usr=rpUserTxt.getText();
            String pwd=String.copyValueOf(rpPwdTxt.getPassword());
            if(driver==null || url==null){
                msg.showAlert(this, "settings_report_err");
                return false;
            }
            settings.reporterClass="JDBCReporter";
            StringBuilder sb=new StringBuilder("driver=").append(driver);
            sb.append(";url=").append(url);
            if(usr!=null){
                sb.append(";system_user=").append(usr);
                if(pwd!=null)
                    sb.append(";system_pwd=").append(pwd);
            }
            settings.reporterParams=sb.substring(0);
        }
        else{
            settings.reporterClass=rpClassTxt.getText();
            settings.reporterParams=rpParamsTxt.getText();            
        }
                    
        settings.password=p1;            
        settings.passwordConfirmed=false;        
        settings.lookAndFeel=(String)lookCombo.getSelectedItem();
        settings.preferredBrowser=browserField.getText();
        settings.skin=(String)skinCombo.getSelectedItem();
        settings.language=Messages.getLanguageFromDescriptive((String)langCombo.getSelectedItem());
        settings.country=StrUtils.nullableString(countryField.getText());
        settings.variant=StrUtils.nullableString(variantField.getText());
        settings.reporterEnabled=reportChk.isSelected();
        settings.soundEnabled=soundEnabledChk.isSelected();
        
        if(mJMFbtn.isSelected())
            settings.mediaSystem=edu.xtec.jclic.Constants.JMF;
        else if(mQTbtn.isSelected())
            settings.mediaSystem=edu.xtec.jclic.Constants.QT;
        else
            settings.mediaSystem=edu.xtec.jclic.Constants.DEFAULT;
        
        settings.systemSounds=systemSoundsChk.isSelected();
        libraryManager.autoRun=autoRunLibChk.isSelected();
        settings.libraryManager=libraryManager;
        return true;
    }        
    
    private void checkEnabled(javax.swing.JComponent cmp){
        if(cmp==null || cmp==reportChk){
            enable(tcpBtn, reportChk, null);
            enable(rpAddressTxt, tcpBtn, reportChk);
            enable(jdbcBtn, reportChk, null);
            enable(rpDriverTxt, jdbcBtn, reportChk);
            enable(rpUrlTxt, jdbcBtn, reportChk);
            enable(rpUserTxt, jdbcBtn, reportChk);
            enable(rpPwdTxt, jdbcBtn, reportChk);
            enable(otherBtn, reportChk, null);
            enable(rpClassTxt, otherBtn, reportChk);
            enable(rpParamsTxt, otherBtn, reportChk);
        }
        if(cmp==null || cmp==pwdCheck){
            enable(pwdField1, pwdCheck, null);
            enable(pwdField2, pwdCheck, null);
        }
        if(cmp==null || cmp==soundEnabledChk){
            enable(mDefaultBtn, soundEnabledChk, null);
            enable(mJMFbtn, soundEnabledChk, null);
            enable(mQTbtn, soundEnabledChk, null);
            enable(systemSoundsChk, soundEnabledChk, null);
        }
    }

    
    private void enable(javax.swing.JComponent cmp, javax.swing.JToggleButton tg1, javax.swing.JToggleButton tg2){
        if(cmp!=null && tg1!=null){
            boolean b=tg1.isSelected() && (tg2==null || tg2.isSelected());
            boolean current=cmp.isEnabled();
            if(b!=current)
                cmp.setEnabled(b);
        }
    }
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox autoRunLibChk;
  private javax.swing.JTextField browserField;
  private javax.swing.JTextField countryField;
  private javax.swing.JPanel editLibPanel;
  private javax.swing.JRadioButton jdbcBtn;
  private javax.swing.JComboBox langCombo;
  private javax.swing.JComboBox<Object> lookCombo;
  private javax.swing.JRadioButton mDefaultBtn;
  private javax.swing.JRadioButton mJMFbtn;
  private javax.swing.JRadioButton mQTbtn;
  private javax.swing.JRadioButton otherBtn;
  private javax.swing.JCheckBox pwdCheck;
  private javax.swing.JPasswordField pwdField1;
  private javax.swing.JPasswordField pwdField2;
  private javax.swing.JCheckBox reportChk;
  private javax.swing.JTextField rpAddressTxt;
  private javax.swing.JTextField rpClassTxt;
  private javax.swing.JTextField rpDriverTxt;
  private javax.swing.JTextField rpParamsTxt;
  private javax.swing.JPasswordField rpPwdTxt;
  private javax.swing.JTextField rpUrlTxt;
  private javax.swing.JTextField rpUserTxt;
  private javax.swing.JComboBox skinCombo;
  private javax.swing.JCheckBox soundEnabledChk;
  private javax.swing.JCheckBox systemSoundsChk;
  private javax.swing.JRadioButton tcpBtn;
  private javax.swing.JTextField variantField;
  // End of variables declaration//GEN-END:variables

}
