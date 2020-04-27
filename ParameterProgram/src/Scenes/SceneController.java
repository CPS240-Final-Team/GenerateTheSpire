package Scenes;
import javafx.application.Application;
import javafx.stage.Stage;

//Author: Hannah Seccia, Ahmed Hamdan, Derrick Vo
//Date Last Worked On: 4-25-2020
//Description: The GUI program that enables the user to construct their card parameters into a class

//the main class that holds the global stage

public class SceneController extends Application
{

	private static Stage mainStage = new Stage();			//the global stage that will be used for the whole program
	
	public Stage getMainStage()								//lets any class access the stage
	{
		return mainStage;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{

		primaryStage.setTitle("Generate the Spire");
		this.mainStage = primaryStage;
		CreationScene creationScene = new CreationScene();		//go to creation scene on start
		
	}

	public static void main(String[] args) 
	{

		launch(args);

	}
	
}
