/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package churdlab8;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author vanil
 */
public class CHurdLab8 extends Application {
    
  Label mStatus = new Label ("Everything is Copacetic");
  Image mBlankImage = new Image("blank.png");
  Image mHorizImage = new Image("horiz.png");
  Image mOImage = new Image("o.png");
  Image mVertImage = new Image("vert.png");
  Image mXImage = new Image("x.png"); 
  ImageView mXImageView = new ImageView(mXImage);
  ImageView mOImageView = new ImageView(mOImage);
  ImageView mBlankImageView = new ImageView(mBlankImage);
  ImageView mHorizImageView;
  ImageView mVertImageView;
  //all images made
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        mXImageView.setUserData("X");
        mOImageView.setUserData("O");


        HBox HXO = new HBox();
        HXO.getChildren().addAll(mXImageView,mOImageView);
        GridPane gridGround = new GridPane();
        gridGround = populatePlayGround(gridGround);
        VBox playGround = new VBox();
        playGround.getChildren().addAll(HXO, gridGround);
        root.setCenter(playGround);
        mXImageView.setOnDragDetected(MouseEvent -> onDrag(MouseEvent));
        mOImageView.setOnDragDetected(MouseEvent -> onDrag(MouseEvent)); 
    
        //onAbout();
        root.setTop(buildMenuBar());
        
        ToolBar toolBar = new ToolBar(mStatus);
        root.setBottom(toolBar);
        
        
        Scene scene = new Scene(root, 280, 425);
        primaryStage.setResizable(false);
        primaryStage.setTitle("TicTacWoah");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("About");
        alert.setHeaderText("Chaz C Hurd, CSCD 370 Lab 8 , Wtr 2020");
        alert.showAndWait();
    }

    private MenuBar buildMenuBar() {
        MenuBar menuBar = new MenuBar();
        //file menu with quit
        Menu fileMenu = new Menu("_File");
        MenuItem quitMenuItem = new MenuItem("_Quit");
        quitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        quitMenuItem.setOnAction(actionEvent -> Platform.exit());
        fileMenu.getItems().add(quitMenuItem);
        
        // next is a help menu
        Menu helpMenu = new Menu("_Help");
        MenuItem aboutMenuItem = new MenuItem("_About");
        aboutMenuItem.setOnAction(actionEvent -> onAbout());
        helpMenu.getItems().add(aboutMenuItem);
        
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        
        return menuBar;
    }

    private void setStatus(String input) {
        
       mStatus.setText(input);
    }

    private GridPane populatePlayGround(GridPane playGround) {
        ImageView b1 = new ImageView(mBlankImage);
        b1.setUserData("BLANK");
        b1.setOnDragOver(DragEvent -> onOver(DragEvent));
        b1.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        ImageView h1 = new ImageView(mHorizImage);
        ImageView v1 = new ImageView(mVertImage);
        //.add(COLUMN, ROW, CSPAN, RSPAN)
        playGround.add(b1,0,0,1,1);
        playGround.add(h1,0,1,1,1);
        playGround.add(v1,1,0,1,1);
        //first box and lines done
        ImageView b2 = new ImageView(mBlankImage);
        b2.setUserData("BLANK");
        b2.setOnDragOver(DragEvent -> onOver(DragEvent));
        b2.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        ImageView h2 = new ImageView(mHorizImage);
        ImageView v2 = new ImageView(mVertImage);
        
        playGround.add(b2,2,0,1,1);
        playGround.add(h2,2,1,1,1);
        playGround.add(v2,3,0,1,1);
        
        ImageView b3 = new ImageView(mBlankImage);
        b3.setUserData("BLANK");
        b3.setOnDragOver(DragEvent -> onOver(DragEvent));
        b3.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        ImageView h3 = new ImageView(mHorizImage);
        
        playGround.add(b3,4,0,1,1);
        playGround.add(h3,4,1,1,1);
        ///ALL DONE WITH ROW 0,1  COPY AND PASTE FOR ROW 2,3
        
        ImageView b12 = new ImageView(mBlankImage);
        b12.setUserData("BLANK");
        b12.setOnDragOver(DragEvent -> onOver(DragEvent));
        b12.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        ImageView h12 = new ImageView(mHorizImage);
        ImageView v12 = new ImageView(mVertImage);
        //.add(COLUMN, ROW, CSPAN, RSPAN)
        playGround.add(b12,0,2,1,1);
        playGround.add(h12,0,3,1,1);
        playGround.add(v12,1,2,1,1);
        
        ImageView b22 = new ImageView(mBlankImage);
        b22.setUserData("BLANK");
        b22.setOnDragOver(DragEvent -> onOver(DragEvent));
        b22.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        ImageView h22 = new ImageView(mHorizImage);
        ImageView v22 = new ImageView(mVertImage);
        
        playGround.add(b22,2,2,1,1);
        playGround.add(h22,2,3,1,1);
        playGround.add(v22,3,2,1,1);
        
        ImageView b32 = new ImageView(mBlankImage);
        b32.setUserData("BLANK");
        b32.setOnDragOver(DragEvent -> onOver(DragEvent));
        b32.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        ImageView h32 = new ImageView(mHorizImage);
        
        playGround.add(b32,4,2,1,1);
        playGround.add(h32,4,3,1,1);
         
        //FINSIHED WITH ROW 3,4 TIME TO GET 5,6
        
        ImageView b13 = new ImageView(mBlankImage);
        b13.setUserData("BLANK");
        b13.setOnDragOver(DragEvent -> onOver(DragEvent));
        b13.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        ImageView v13 = new ImageView(mVertImage);
        //.add(COLUMN, ROW, CSPAN, RSPAN)
        playGround.add(b13,0,4,1,1);
        playGround.add(v13,1,4,1,1);
        
        ImageView b23 = new ImageView(mBlankImage);
        b23.setUserData("BLANK");
        b23.setOnDragOver(DragEvent -> onOver(DragEvent));
        b23.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        ImageView v23 = new ImageView(mVertImage);
        
        playGround.add(b23,2,4,1,1);
        playGround.add(v23,3,4,1,1);
        
        ImageView b33 = new ImageView(mBlankImage);
        b33.setUserData("BLANK");
        b33.setOnDragOver(DragEvent -> onOver(DragEvent));
        b33.setOnDragDropped(DragEvent -> onDrop(DragEvent));
        playGround.add(b33,4,4,1,1);
        return playGround;
    }

    private void onDrag(MouseEvent MouseEvent) {
        Object cImage = MouseEvent.getSource();
        ImageView curImage = (ImageView)(cImage);
        Dragboard dragBoard = curImage.startDragAndDrop(TransferMode.COPY);
        dragBoard.setDragView(curImage.getImage(),curImage.getImage().getWidth()*.5, curImage.getImage().getHeight()*.5);
        ClipboardContent cbContent = new ClipboardContent();
        cbContent.putString((String)curImage.getUserData());
        dragBoard.setContent(cbContent);
        
        
    }   

    private void onOver(DragEvent DragEvent) {
        Object cImage = DragEvent.getTarget();
        ImageView curImage = (ImageView)cImage;
        String uData = (String) curImage.getUserData();
        if(!uData.equals("BLANK")){
            return;
        }
        Dragboard db = DragEvent.getDragboard();
        if(db.getString()!=null){
            if(db.getString().equals("X") || db.getString().equals("O")){
                DragEvent.acceptTransferModes(TransferMode.COPY);
            }
        }
        if(!db.equals("X")|| !db.equals("O"))
        {
            setStatus("Only X and O may be used");
        }
    }

    private void onDrop(DragEvent DragEvent) {
        Object cImage = DragEvent.getTarget();
        ImageView curImage = (ImageView)cImage;
        Dragboard curDB = DragEvent.getDragboard();
        
        String dragee = curDB.getString();
        if(dragee.equals("X")){
            curImage.setImage(mXImage);
            curImage.setUserData("X");
        }else{
            curImage.setImage(mOImage);
            curImage.setUserData("O");
        }

        DragEvent.setDropCompleted(true);
        
        
    }


}
