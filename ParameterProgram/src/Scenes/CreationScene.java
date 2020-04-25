package Scenes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import Classes.CardParameterPartial;
import Enums.CardColor;
import Enums.CardRarity;
import Enums.CardSpecialEffects;
import Enums.CardType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

//The scene that lets the user enter basic information about a card (ID, name, cost, etc)

public class CreationScene 
{
	SceneController sceneControl = new SceneController();
	
	public CreationScene() throws FileNotFoundException
	{
		
		/////////////////////// CONTROL CREATION //////////////////////////////////
		
		FileInputStream imageFIS = new FileInputStream("resources/spireLogo.png");
		Image logoImage = new Image(imageFIS);
		ImageView logoView = new ImageView(logoImage);
		
		Label idInputLabel = new Label("Enter the file ID of your card (no spaces): ");
		TextField idInputField = new TextField();
		idInputField.setPrefWidth(200);
		idInputField.setMaxWidth(200);
		
		Label cardNameInputLabel = new Label("Enter the name of your card: ");
		TextField cardNameInputField = new TextField();
		cardNameInputField.setPrefWidth(200);
		cardNameInputField.setMaxWidth(200);
		
		Label cardDescInputLabel = new Label("Enter the description text of your card: ");
		TextField cardDescInputField = new TextField();
		cardDescInputField.setPrefWidth(400);
		
		Label cardCostInputLabel = new Label("Enter the cost of your card: ");
		TextField cardCostInputField = new TextField();
		cardCostInputField.setPrefWidth(40);
		cardCostInputField.setMaxWidth(40);
		
		Label cardTypeInputLabel = new Label("Choose the type of the card: ");
		ComboBox<CardType> cardTypeInputBox = new ComboBox<CardType>();
		cardTypeInputBox.getItems().add(CardType.Attack);
		cardTypeInputBox.getItems().add(CardType.Curse);
		cardTypeInputBox.getItems().add(CardType.Power);
		cardTypeInputBox.getItems().add(CardType.Skill);
		cardTypeInputBox.getItems().add(CardType.Status);
		
		Label cardEffectInputLabel = new Label("Choose your card's special effects: ");
		CheckBox cardUnplayableInputBox = new CheckBox("Unplayable");
		CheckBox cardExhaustInputBox = new CheckBox("Exhaust");
		CheckBox cardEtheralInputBox = new CheckBox("Etheral");
		CheckBox cardInnateInputBox = new CheckBox("Innate");
		CheckBox cardRetainInputBox = new CheckBox("Retain");
		
		Label cardColorInputLabel = new Label("Choose your card's color: ");
		ComboBox<CardColor>cardColorInputBox = new ComboBox<CardColor>();
		cardColorInputBox.getItems().add(CardColor.Blue);
		cardColorInputBox.getItems().add(CardColor.Green);
		cardColorInputBox.getItems().add(CardColor.Red);
		
		Label cardRarityInputLabel = new Label("Choose your card's rarity: ");
		ComboBox<CardRarity> cardRarityInputBox = new ComboBox<CardRarity>();
		cardRarityInputBox.getItems().add(CardRarity.Common);
		cardRarityInputBox.getItems().add(CardRarity.Uncommon);
		cardRarityInputBox.getItems().add(CardRarity.Rare);
		
		Label statusLabel = new Label("");
		statusLabel.setTextFill(Paint.valueOf(Color.ORANGERED.toString()));
		
		Button nextPageButton = new Button("Next ->");
		nextPageButton.setTextFill(Paint.valueOf("#ffffff"));
		nextPageButton.setStyle("-fx-base: rgb(30,170,255);");



		/////////////////////// CONTROL CREATION //////////////////////////////////


		/////////////////////// BOX CREATION //////////////////////////////////

		HBox logoBox = new HBox(logoView);
		logoBox.setAlignment(Pos.CENTER);
		
		VBox cardInfoInputBox = new VBox(idInputLabel, idInputField, cardNameInputLabel, cardNameInputField, cardDescInputLabel, cardDescInputField, cardCostInputLabel, cardCostInputField);
		cardInfoInputBox.setAlignment(Pos.CENTER);
		cardInfoInputBox.setSpacing(10);
		
		VBox cardTypeBox = new VBox(cardTypeInputLabel, cardTypeInputBox, cardEffectInputLabel);
		cardTypeBox.setAlignment(Pos.CENTER);
		cardInfoInputBox.setSpacing(10);
		
		VBox cardEffectBox = new VBox(cardEffectInputLabel, cardUnplayableInputBox, cardExhaustInputBox, cardEtheralInputBox, cardInnateInputBox, cardRetainInputBox);
		cardEffectBox.setAlignment(Pos.CENTER);
		cardEffectBox.setSpacing(10);
		
		VBox cardOtherOptionsBox = new VBox(cardColorInputLabel, cardColorInputBox, cardRarityInputLabel, cardRarityInputBox);
		cardOtherOptionsBox.setAlignment(Pos.CENTER);
		cardOtherOptionsBox.setSpacing(10);
		
		HBox statusLabelBox = new HBox(statusLabel);
		statusLabelBox.setAlignment(Pos.CENTER);
		statusLabelBox.setSpacing(20);
		
		VBox generalInfoBox = new VBox(cardInfoInputBox, cardTypeBox, cardEffectBox, cardOtherOptionsBox, statusLabelBox);
		generalInfoBox.setAlignment(Pos.CENTER);
		generalInfoBox.setSpacing(10);
		
		HBox nextPageButtonBox = new HBox(nextPageButton);


		/////////////////////// BOX CREATION //////////////////////////////////

		/////////////////////// PANE CREATION //////////////////////////////////

		BorderPane mainPagePane = new BorderPane();
		mainPagePane.setPadding(new Insets(10,10,10,10));
		mainPagePane.setTop(logoBox);
		mainPagePane.setCenter(generalInfoBox);
		mainPagePane.setMinSize(500, 700);
		mainPagePane.setBottom(nextPageButtonBox);
		mainPagePane.setStyle("-fx-background-color: #D3D3D3; ");


		/////////////////////// PANE CREATION //////////////////////////////////



		Scene creationScene = new Scene(mainPagePane);
	
		
		sceneControl.getMainStage().setScene(creationScene);
		sceneControl.getMainStage().show();


		/////////////////////// CONTROL EVENT HANDLING ///////////////////////////

		nextPageButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override public void handle(ActionEvent e) 
			{
				Boolean allChecksPassed = true;											//a boolean to make sure that all text fields contain valid content
				
				if(idInputField.getText().contains(" "))
				{
					statusLabel.setText("The ID must have no spaces.");
					allChecksPassed = false;
				}
				
				try																		//makes sure that the card cost is only integers
				{
					Integer.parseInt(cardCostInputField.getText());
				}
				catch (Exception exceptionArg)
				{
					statusLabel.setText("The card cost must be an integer value.");
					allChecksPassed = false;
				}
				
								
				CardSpecialEffects[] checkedEffects = new CardSpecialEffects[5];		//make a temp array to pull selected check boxes; unchecked boxes will be stored as null
	
				if(cardUnplayableInputBox.isSelected())
				{
					checkedEffects[0] = CardSpecialEffects.Unplayable;  				//0 in array will represent the status of unplayable 
				}
	
				if(cardExhaustInputBox.isSelected())
				{
					checkedEffects[1] = CardSpecialEffects.Exhaust;						//1 in array will represent the status of exhaust 
				}
	
				if(cardEtheralInputBox.isSelected())
				{
					checkedEffects[2] = CardSpecialEffects.Etheral;						//2 in array will represent the status of etheral
				}
			
				if(cardInnateInputBox.isSelected())
				{
					checkedEffects[3] = CardSpecialEffects.Innate;						//3 in array will represent the status of innate
				}
	
				if(cardRetainInputBox.isSelected())
				{
					checkedEffects[4] = CardSpecialEffects.Retain;						//4 in array will represent the status of retain
				}
	
				if(allChecksPassed)
				{
				  statusLabel.setText("");
				  
				  //make a class that stores information from this scene to be passed to the next one
				  CardParameterPartial partialClass = new CardParameterPartial(idInputField.getText(), cardNameInputField.getText(), cardDescInputField.getText(), Integer.parseInt(cardCostInputField.getText()), cardTypeInputBox.getValue(), checkedEffects, cardColorInputBox.getValue(), cardRarityInputBox.getValue());
				  
				  sceneControl.getMainStage().close();									//close this current scene 
				  
				  try 																	//create a new event scene
				  {
					EventScene eventScene = new EventScene(partialClass);
				  } 
				  catch (FileNotFoundException e1)
				  {
				
					e1.printStackTrace();
				  }
				}
			}
		});

	}
	
	

/////////////////////// CONTROL EVENT HANDLING /////////////////////////
	
}
