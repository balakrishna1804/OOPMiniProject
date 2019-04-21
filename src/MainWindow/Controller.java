package MainWindow;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ToggleButton tglBtn_FoundationPhase;
    public ToggleButton tglBtn_ShellBuildingPhase;
    public ToggleButton tglBtn_InteriorBuildingPhase;
    public ToggleButton tglBtn_DesignPhase;
    public ToggleGroup tglGrp_Phase;

    public AnchorPane anchorPane_FoundationPhase;

    boolean phase1_Foundation = false;
    boolean phase2_ShellBuilding = false;
    boolean phase3_InteriorBuilding = false;
    boolean phase4_Design = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //get the phase boolean variables from database

        int currentPhase = 1;

        tglBtn_FoundationPhase.setDisable(false);
        tglBtn_ShellBuildingPhase.setDisable(true);
        tglBtn_InteriorBuildingPhase.setDisable(true);
        tglBtn_DesignPhase.setDisable(true);

        tglBtn_FoundationPhase.setSelected(false);
        tglBtn_ShellBuildingPhase.setSelected(false);
        tglBtn_InteriorBuildingPhase.setSelected(false);
        tglBtn_DesignPhase.setSelected(false);

        anchorPane_FoundationPhase.setVisible(false);
        //remaining anchor panes visibility = false

        if(phase1_Foundation) {
            tglBtn_ShellBuildingPhase.setDisable(false);
            currentPhase = 2;
            if(phase2_ShellBuilding) {
                tglBtn_InteriorBuildingPhase.setDisable(false);
                currentPhase = 3;
                if(phase3_InteriorBuilding) {
                    tglBtn_DesignPhase.setDisable(false);
                    currentPhase = 4;
                    if(phase4_Design){
                        currentPhase = 0;
                    }
                }
            }

        }



        if(currentPhase == 0){
            //all phases are completed.
        }
        else{
            //show current phase on the screen
            if(currentPhase==1){
                tglBtn_FoundationPhase.setSelected(true);
                anchorPane_FoundationPhase.setVisible(true);
            }
            else if(currentPhase==2){
                tglBtn_ShellBuildingPhase.setDisable(true);
            }
        }

    }


    public void tglBtn_FoundationPhase_clicked(ActionEvent actionEvent) {

        if(tglBtn_FoundationPhase.isSelected()){
            anchorPane_FoundationPhase.setVisible(true);
            if(phase1_Foundation){
                //anchorPane_FoundationPhase.setDisable(true);
                //disable all the active elements present in this phase. i.e., text fields, update info kind of things.
            }
        }
        else{
            anchorPane_FoundationPhase.setVisible(false);
        }
    }
}
