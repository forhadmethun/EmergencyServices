/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyservices;

import emergencyservices.models.AreaModel;
import java.util.Vector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.WaitScreen;
import org.netbeans.microedition.util.SimpleCancellableTask;

/**
 * @author Methun
 */
public class HelloMIDlet extends MIDlet implements CommandListener {

    int currentStation = 0;
    int currentDivision = 0;
    int currentType = 0;
    int currentDistrictId = 0;
    private boolean midletPaused = false;
    private String Response = "";
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command exitCommand1;
    private Command okCommand;
    private Command backCommand;
    private Command okCommand1;
    private Command backCommand1;
    private Command okCommand2;
    private Command backCommand2;
    private Command backCommand3;
    private Command okCommand3;
    private Command backCommand4;
    private List allStationList;
    private List policeStaionList;
    private List DivisionList;
    private List DistrictList;
    private List detailsStationInfo;
    private TextBox textBox;
    private SimpleCancellableTask task;
    private Image image1;
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The HelloMIDlet constructor.
     */
    Vector vector = new Vector();

    public HelloMIDlet() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|
//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the
     * <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getAllStationList());
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The
     * <code>display</code> instance is taken from
     * <code>getDisplay</code> method. This method is used by all actions in the
     * design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display;
     * if <code>null</code>, then <code>nextDisplayable</code> is set
     * immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == DistrictList) {//GEN-BEGIN:|7-commandAction|1|61-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|61-preAction
                // write pre-action user code here
                DistrictListAction();//GEN-LINE:|7-commandAction|2|61-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|3|64-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|4|64-postAction
                // write post-action user code here
                switchDisplayable(null, getDivisionList());




            } else if (command == okCommand3) {//GEN-LINE:|7-commandAction|5|66-preAction
                // write pre-action user code here


                List c1 = getDistrictList();
                StringItem message[] = new StringItem[c1.size()];
                boolean get[] = new boolean[c1.size()];
                c1.getSelectedFlags(get);
                for (int i = 0; i < get.length; i++) {
                    System.out.println("index : " + i);
                    if (get[i]) {
                        System.out.println("found index : " + i);
                        currentDistrictId = ((AreaModel) (vector.elementAt(i))).id;
                        utility u = new utility();

                        try {
                            Response = u.sendPostRequest(currentType + "", currentDistrictId + "");
                            System.out.println("the response is : " + Response);
                            textBox=null;
                            switchDisplayable(null, getTextBox());
                        } catch (Exception e) {
                        }


                    }
                }




//GEN-LINE:|7-commandAction|6|66-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|49-preAction
        } else if (displayable == DivisionList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|7|49-preAction
                // write pre-action user code here
                DivisionListAction();//GEN-LINE:|7-commandAction|8|49-postAction
                // write post-action user code here
            } else if (command == backCommand2) {//GEN-LINE:|7-commandAction|9|53-preAction
                // write pre-action user code here
                switchDisplayable(null, getAllStationList());
//GEN-LINE:|7-commandAction|10|53-postAction
                // write post-action user code here
            } else if (command == okCommand2) {//GEN-LINE:|7-commandAction|11|55-preAction
                // write pre-action user code here

                List c1 = getDivisionList();
                StringItem message[] = new StringItem[c1.size()];
                boolean get[] = new boolean[c1.size()];
                c1.getSelectedFlags(get);
                for (int i = 0; i < get.length; i++) {
                    if (get[i]) {
                        currentDivision = i;
                        DistrictList=null;
                        switchDisplayable(null, getDistrictList());
                        break;


                    }
                }








//GEN-LINE:|7-commandAction|12|55-postAction
                /*    // write post-action user code here
//GEN-BEGIN:|7-commandAction|13|24-preAction
                 }
                 } else if (displayable == allStationList) {
                 if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|13|24-preAction
                // write pre-action user code here
                
//GEN-BEGIN:|7-commandAction|14|24-postAction
                 allStationListAction ();//GEN-END:|7-commandAction|14|24-postAction
                // write post-action user code here
                
//GEN-BEGIN:|7-commandAction|15|58-preAction
                 } else if (command == exitCommand) {//GEN-END:|7-commandAction|15|58-preAction
                // write pre-action user code here
                 */
            }
        } else if (displayable == allStationList) {
            if (command == exitCommand) {

                notifyDestroyed();

//GEN-LINE:|7-commandAction|16|58-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|17|32-preAction
                // write pre-action user code here
                currentStation = 1;
                System.out.println("clicjed");
                //switchDisplayable(null, getList1()); 

                List c1 = getAllStationList();
                StringItem message[] = new StringItem[c1.size()];
                boolean get[] = new boolean[c1.size()];
                c1.getSelectedFlags(get);
                for (int i = 0; i < get.length; i++) {
                    if (get[i]) {

                        if (c1.getString(i).equals("Police Station")) {

                            currentType = 1;
                            System.out.println("it is working .....|_|_");
                            DivisionList=null;
                            switchDisplayable(null, getDivisionList());
//                            policeStaionList=null;
//                            switchDisplayable(null, getPoliceStaionList());
                        } else if (c1.getString(i).equals("Fire Station")) {
                            // showInput(); 
                            currentType = 2;
                            System.out.println("it is working .....|_|_");
                            DivisionList=null;
                            switchDisplayable(null, getDivisionList());
                            
                        }


                    }
                }


//GEN-LINE:|7-commandAction|18|32-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|19|68-preAction
        } else if (displayable == detailsStationInfo) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|19|68-preAction
                // write pre-action user code here
                detailsStationInfoAction();//GEN-LINE:|7-commandAction|20|68-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|21|71-preAction
                // write pre-action user code here
                switchDisplayable(null, getDistrictList());

//GEN-LINE:|7-commandAction|22|71-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|34-preAction
        } else if (displayable == policeStaionList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|23|34-preAction
                // write pre-action user code here
                policeStaionListAction();//GEN-LINE:|7-commandAction|24|34-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|25|37-preAction
                // write pre-action user code here
                switchDisplayable(null, getAllStationList());

//GEN-LINE:|7-commandAction|26|37-postAction
                // write post-action user code here
            } else if (command == okCommand2) {//GEN-LINE:|7-commandAction|27|75-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|28|75-postAction
                // write post-action user code here
                List c1 = getDivisionList();
                StringItem message[] = new StringItem[c1.size()];
                boolean get[] = new boolean[c1.size()];
                c1.getSelectedFlags(get);
                for (int i = 0; i < get.length; i++) {
                    if (get[i]) {
                        currentDivision = i;
                        DistrictList=null;
                        switchDisplayable(null, getDistrictList());


                    }
                }
            }//GEN-BEGIN:|7-commandAction|29|74-preAction
        } else if (displayable == textBox) {
            if (command == backCommand4) {//GEN-END:|7-commandAction|29|74-preAction
                // write pre-action user code here

                switchDisplayable(null, getDistrictList());

//GEN-LINE:|7-commandAction|30|74-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|31|7-postCommandAction
        }//GEN-END:|7-commandAction|31|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|32|
//</editor-fold>//GEN-END:|7-commandAction|32|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: allStationList ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of allStationList component.
     *
     * @return the initialized component instance
     */
    public List getAllStationList() {
        if (allStationList == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            allStationList = new List("Services", Choice.IMPLICIT);//GEN-BEGIN:|22-getter|1|22-postInit
            allStationList.append("Police Station", null);
            allStationList.append("Fire Station", null);
            allStationList.addCommand(getOkCommand());
            allStationList.addCommand(getExitCommand());
            allStationList.setCommandListener(this);
            allStationList.setSelectedFlags(new boolean[]{false, false});//GEN-END:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return allStationList;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: allStationListAction ">//GEN-BEGIN:|22-action|0|22-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * allStationList component.
     */
    public void allStationListAction() {//GEN-END:|22-action|0|22-preAction
        // enter pre-action user code here
        String __selectedString = getAllStationList().getString(getAllStationList().getSelectedIndex());//GEN-BEGIN:|22-action|1|26-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Police Station")) {//GEN-END:|22-action|1|26-preAction
                // write pre-action user code here
//GEN-LINE:|22-action|2|26-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Fire Station")) {//GEN-LINE:|22-action|3|27-preAction
                // write pre-action user code here
//GEN-LINE:|22-action|4|27-postAction
                // write post-action user code here
            }//GEN-BEGIN:|22-action|5|22-postAction
        }//GEN-END:|22-action|5|22-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|22-action|6|
//</editor-fold>//GEN-END:|22-action|6|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|29-getter|1|29-postInit
            // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|29-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|31-getter|1|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|31-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: policeStaionList ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initialized instance of policeStaionList component.
     *
     * @return the initialized component instance
     */
    public List getPoliceStaionList() {
        if (policeStaionList == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
/*
//GEN-BEGIN:|33-getter|1|33-postInit
             policeStaionList = new List ("Police Station", Choice.IMPLICIT);
             policeStaionList.append ("Metropoliton Police", null);
             policeStaionList.append ("Range Police", null);
             policeStaionList.addCommand (getBackCommand ());
             policeStaionList.addCommand (getOkCommand2 ());
             policeStaionList.setCommandListener (this);
             policeStaionList.setSelectedFlags (new boolean[] { false, false });//GEN-END:|33-getter|1|33-postInit
            */
            policeStaionList = new List("Select Division", Choice.IMPLICIT);


            vector.removeAllElements();
            vector = Global.getAllDivisionList();
            boolean flag[] = new boolean[vector.size()];
            for (int i = 0; i < vector.size(); i++) {
                String divName = ((AreaModel) vector.elementAt(i)).name;
                policeStaionList.append(divName, null);
                flag[i] = false;
            }
            //fireStationDivisionList.append("List Element 2", null);
            policeStaionList.addCommand(getBackCommand());
            policeStaionList.addCommand(getOkCommand2());
            policeStaionList.setCommandListener(this);
            policeStaionList.setSelectedFlags(flag);

            // write post-init user code here
        }//GEN-BEGIN:|33-getter|2|
        return policeStaionList;
    }
//</editor-fold>//GEN-END:|33-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: policeStaionListAction ">//GEN-BEGIN:|33-action|0|33-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * policeStaionList component.
     */
    public void policeStaionListAction() {//GEN-END:|33-action|0|33-preAction
        // enter pre-action user code here
        String __selectedString = getPoliceStaionList().getString(getPoliceStaionList().getSelectedIndex());//GEN-BEGIN:|33-action|1|38-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Metropoliton Police")) {//GEN-END:|33-action|1|38-preAction
                // write pre-action user code here
//GEN-LINE:|33-action|2|38-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Range Police")) {//GEN-LINE:|33-action|3|39-preAction
                // write pre-action user code here
//GEN-LINE:|33-action|4|39-postAction
                // write post-action user code here
            }//GEN-BEGIN:|33-action|5|33-postAction
        }//GEN-END:|33-action|5|33-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|33-action|6|
//</editor-fold>//GEN-END:|33-action|6|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|36-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initialized instance of backCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return backCommand1;
    }
//</editor-fold>//GEN-END:|44-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|46-getter|0|46-preInit
    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|46-getter|1|46-postInit
            // write post-init user code here
        }//GEN-BEGIN:|46-getter|2|
        return okCommand1;
    }
//</editor-fold>//GEN-END:|46-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initialized instance of backCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand2() {
        if (backCommand2 == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            backCommand2 = new Command("Back", Command.BACK, 0);//GEN-LINE:|52-getter|1|52-postInit
            // write post-init user code here
        }//GEN-BEGIN:|52-getter|2|
        return backCommand2;
    }
//</editor-fold>//GEN-END:|52-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initialized instance of okCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            okCommand2 = new Command("Ok", Command.OK, 0);//GEN-LINE:|54-getter|1|54-postInit
            // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return okCommand2;
    }
//</editor-fold>//GEN-END:|54-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: DivisionList ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initialized instance of DivisionList component.
     *
     * @return the initialized component instance
     */
    public List getDivisionList() {
        if (DivisionList == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
            /*
//GEN-BEGIN:|48-getter|1|48-postInit
             DivisionList = new List ("Select Division", Choice.IMPLICIT);
             DivisionList.append ("Barisal Divsion", null);
             DivisionList.append ("List Element 2", null);
             DivisionList.addCommand (getBackCommand2 ());
             DivisionList.addCommand (getOkCommand2 ());
             DivisionList.setCommandListener (this);
             DivisionList.setSelectedFlags (new boolean[] { false, false });//GEN-END:|48-getter|1|48-postInit
             
             */
            DivisionList = new List("Select Division", Choice.IMPLICIT);

            vector.removeAllElements();
            vector = Global.getAllDivisionList();
            boolean flag[] = new boolean[vector.size()];
            for (int i = 0; i < vector.size(); i++) {
                String divName = ((AreaModel) vector.elementAt(i)).name;
                DivisionList.append(divName, null);
                flag[i] = false;
            }
            //fireStationDivisionList.append("List Element 2", null);
            DivisionList.addCommand(getBackCommand2());
            DivisionList.addCommand(getOkCommand2());
            DivisionList.setCommandListener(this);
            DivisionList.setSelectedFlags(flag);

            // write post-init user code here
            /*
//GEN-BEGIN:|48-getter|2|
             }
             return DivisionList;
             }
             //</editor-fold>//GEN-END:|48-getter|2|
*/
            
            
        }
        return DivisionList;
    }
            
//<editor-fold defaultstate="collapsed" desc=" Generated Method: DivisionListAction ">//GEN-BEGIN:|48-action|0|48-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * DivisionList component.
     */
    public void DivisionListAction() {//GEN-END:|48-action|0|48-preAction
        // enter pre-action user code here
        String __selectedString = getDivisionList().getString(getDivisionList().getSelectedIndex());//GEN-BEGIN:|48-action|1|51-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Barisal Divsion")) {//GEN-END:|48-action|1|51-preAction
                // write pre-action user code here
//GEN-LINE:|48-action|2|51-postAction
                // write post-action user code here
            } else if (__selectedString.equals("List Element 2")) {//GEN-LINE:|48-action|3|59-preAction
                // write pre-action user code here
//GEN-LINE:|48-action|4|59-postAction
                // write post-action user code here
            }//GEN-BEGIN:|48-action|5|48-postAction
        }//GEN-END:|48-action|5|48-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|48-action|6|
//</editor-fold>//GEN-END:|48-action|6|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand3 ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initialized instance of backCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand3() {
        if (backCommand3 == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            backCommand3 = new Command("Back", Command.BACK, 0);//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return backCommand3;
    }
//</editor-fold>//GEN-END:|56-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: DistrictList ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initialized instance of DistrictList component.
     *
     * @return the initialized component instance
     */
    public List getDistrictList() {
        if (DistrictList == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            /*
//GEN-BEGIN:|60-getter|1|60-postInit
             DistrictList = new List ("Select District", Choice.IMPLICIT);
             DistrictList.append ("List Element 1", null);
             DistrictList.addCommand (getBackCommand ());
             DistrictList.addCommand (getOkCommand3 ());
             DistrictList.setCommandListener (this);
             DistrictList.setSelectedFlags (new boolean[] { false });//GEN-END:|60-getter|1|60-postInit
            
             */
            // write post-init user code here

            DistrictList = new List("Select District", Choice.IMPLICIT);
            vector.removeAllElements();
            vector = Global.getDistrictListByDivision(currentDivision);

            boolean flag[] = new boolean[vector.size()];
            for (int i = 0; i < vector.size(); i++) {
                String divName = ((AreaModel) vector.elementAt(i)).name;
                DistrictList.append(divName, null);
                flag[i] = false;
            }
//            FireStationDistrictList.append("List Element 1", null);
            DistrictList.addCommand(getBackCommand());
            DistrictList.addCommand(getOkCommand3());
            DistrictList.setCommandListener(this);
            DistrictList.setSelectedFlags(flag);

            /*
//GEN-BEGIN:|60-getter|2|
             }
             return DistrictList;
             }
             //</editor-fold>//GEN-END:|60-getter|2|

             */

        } 
//        else {
//            
//            vector=new Vector();
//            vector = Global.getDistrictListByDivision(currentDivision);
//
//            boolean flag[] = new boolean[vector.size()];
//            for (int i = 0; i < vector.size(); i++) {
//                String divName = ((AreaModel) vector.elementAt(i)).name;
//                DistrictList.append(divName, null);
//                flag[i] = false;
//            }            
//            DistrictList.setSelectedFlags(flag);
//        }
        return DistrictList;


    }

//<editor-fold defaultstate="collapsed" desc=" Generated Method: DistrictListAction ">//GEN-BEGIN:|60-action|0|60-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * DistrictList component.
     */
    public void DistrictListAction() {//GEN-END:|60-action|0|60-preAction
        // enter pre-action user code here
        String __selectedString = getDistrictList().getString(getDistrictList().getSelectedIndex());//GEN-BEGIN:|60-action|1|63-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("List Element 1")) {//GEN-END:|60-action|1|63-preAction
                // write pre-action user code here
//GEN-LINE:|60-action|2|63-postAction
                // write post-action user code here
            }//GEN-BEGIN:|60-action|3|60-postAction
        }//GEN-END:|60-action|3|60-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|60-action|4|
//</editor-fold>//GEN-END:|60-action|4|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand3 ">//GEN-BEGIN:|65-getter|0|65-preInit
    /**
     * Returns an initialized instance of okCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand3() {
        if (okCommand3 == null) {//GEN-END:|65-getter|0|65-preInit
            // write pre-init user code here
            okCommand3 = new Command("Ok", Command.OK, 0);//GEN-LINE:|65-getter|1|65-postInit
            // write post-init user code here
        }//GEN-BEGIN:|65-getter|2|
        return okCommand3;
    }
//</editor-fold>//GEN-END:|65-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: detailsStationInfo ">//GEN-BEGIN:|67-getter|0|67-preInit
    /**
     * Returns an initialized instance of detailsStationInfo component.
     *
     * @return the initialized component instance
     */
    public List getDetailsStationInfo() {
        if (detailsStationInfo == null) {//GEN-END:|67-getter|0|67-preInit
            // write pre-init user code here

            /*
//GEN-BEGIN:|67-getter|1|67-postInit
             detailsStationInfo = new List ("Details", Choice.IMPLICIT);
             detailsStationInfo.append ("details_info", null);
             detailsStationInfo.addCommand (getBackCommand ());
             detailsStationInfo.setCommandListener (this);
             detailsStationInfo.setSelectedFlags (new boolean[] { false });//GEN-END:|67-getter|1|67-postInit
           */
            detailsStationInfo = new List("Details Info", Choice.IMPLICIT);
            detailsStationInfo.append(Response, null);
            detailsStationInfo.setCommandListener(this);
            //detailsStationInfo.setSelectedFlags(new boolean[]{false});




            // write post-init user code here
        }//GEN-BEGIN:|67-getter|2|
        return detailsStationInfo;
    }
//</editor-fold>//GEN-END:|67-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: detailsStationInfoAction ">//GEN-BEGIN:|67-action|0|67-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * detailsStationInfo component.
     */
    public void detailsStationInfoAction() {//GEN-END:|67-action|0|67-preAction
        // enter pre-action user code here
        String __selectedString = getDetailsStationInfo().getString(getDetailsStationInfo().getSelectedIndex());//GEN-BEGIN:|67-action|1|70-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("details_info")) {//GEN-END:|67-action|1|70-preAction
                // write pre-action user code here
//GEN-LINE:|67-action|2|70-postAction
                // write post-action user code here
            }//GEN-BEGIN:|67-action|3|67-postAction
        }//GEN-END:|67-action|3|67-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|67-action|4|
//</editor-fold>//GEN-END:|67-action|4|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textBox ">//GEN-BEGIN:|72-getter|0|72-preInit
    /**
     * Returns an initialized instance of textBox component.
     *
     * @return the initialized component instance
     */
    public TextBox getTextBox() {
        if (textBox == null) {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
            /*
//GEN-BEGIN:|72-getter|1|72-postInit
             textBox = new TextBox ("", "sdfsd", 100000, TextField.ANY);
             textBox.addCommand (getBackCommand4 ());
             textBox.setCommandListener (this);//GEN-END:|72-getter|1|72-postInit
            // write post-init user code here
             */
            textBox = new TextBox("Station Details", Response, 1000, TextField.UNEDITABLE);
            textBox.addCommand(getBackCommand4());
            textBox.setCommandListener(this);

            //StringTokenizer a;
          /*  
//GEN-BEGIN:|72-getter|2|
             }
             return textBox;
             }
             //</editor-fold>//GEN-END:|72-getter|2|
*/

        }
//        else{
//            textBox = new TextBox("Station Details", Response, 1000, TextField.UNEDITABLE);
//            textBox.addCommand(getBackCommand4());
//            textBox.setCommandListener(this);
//
//        }

        return textBox;


    }

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand4 ">//GEN-BEGIN:|73-getter|0|73-preInit
    /**
     * Returns an initialized instance of backCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand4() {
        if (backCommand4 == null) {//GEN-END:|73-getter|0|73-preInit
            // write pre-init user code here
            backCommand4 = new Command("Back", Command.BACK, 0);//GEN-LINE:|73-getter|1|73-postInit
            // write post-init user code here
        }//GEN-BEGIN:|73-getter|2|
        return backCommand4;
    }
//</editor-fold>//GEN-END:|73-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|81-getter|0|81-preInit
    /**
     * Returns an initialized instance of task component.
     *
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask() {
        if (task == null) {//GEN-END:|81-getter|0|81-preInit
            // write pre-init user code here
            task = new SimpleCancellableTask();//GEN-BEGIN:|81-getter|1|81-execute
            task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|81-getter|1|81-execute
// write task-execution user code here
                }//GEN-BEGIN:|81-getter|2|81-postInit
            });//GEN-END:|81-getter|2|81-postInit
            // write post-init user code here
        }//GEN-BEGIN:|81-getter|3|
        return task;
    }
//</editor-fold>//GEN-END:|81-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|82-getter|0|82-preInit
    /**
     * Returns an initialized instance of image1 component.
     *
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {//GEN-END:|82-getter|0|82-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|82-getter|1|82-@java.io.IOException
                image1 = Image.createImage("/icon.png");
            } catch (java.io.IOException e) {//GEN-END:|82-getter|1|82-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|82-getter|2|82-postInit
            // write post-init user code here
        }//GEN-BEGIN:|82-getter|3|
        return image1;
    }
//</editor-fold>//GEN-END:|82-getter|3|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
}
