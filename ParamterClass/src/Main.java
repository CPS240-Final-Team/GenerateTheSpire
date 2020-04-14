import java.io.FileInputStream;

import Enums.CardColor;
import Enums.CardRarity;
import Enums.CardSpecialEffects;
import Enums.CardType;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Last Worked on By: Hannah 
//Date Last Worked On: 4/13/2020
//Progress Last Made: Made progress on a basic UI 
//What Needs to be Done:
//	- Trigger class creation/composition
//	- Creating another scene to handle input for triggers (scenes are basically like intents/forms/etc)
//	- Attaching logic to the controls to get class needed info from the UI
//	- Generating a parameter file 
//  - my humps my humps my hump
//	- ???????????
//	- profit


public class Main extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
	
		/////////////////////// CONTROL CREATION //////////////////////////////////
		
		FileInputStream imageFIS = new FileInputStream("resources/spireLogo.png");
		Image logoImage = new Image(imageFIS);
		ImageView logoView = new ImageView(logoImage);
		
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
		ComboBox cardTypeInputBox = new ComboBox();
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
		ComboBox cardColorInputBox = new ComboBox();
		cardColorInputBox.getItems().add(CardColor.Blue);
		cardColorInputBox.getItems().add(CardColor.Green);
		cardColorInputBox.getItems().add(CardColor.Red);
		
		Label cardRarityInputLabel = new Label("Choose your card's rarity: ");
		ComboBox cardRarityInputBox = new ComboBox();
		cardRarityInputBox.getItems().add(CardRarity.Common);
		cardRarityInputBox.getItems().add(CardRarity.Uncommon);
		cardRarityInputBox.getItems().add(CardRarity.Rare);
		
		/////////////////////// CONTROL CREATION //////////////////////////////////
		
		/////////////////////// BOX CREATION //////////////////////////////////
		
		HBox logoBox = new HBox(logoView);
		
		VBox cardInfoInputBox = new VBox(cardNameInputLabel, cardNameInputField, cardDescInputLabel, cardDescInputField, cardCostInputLabel, cardCostInputField);
		cardInfoInputBox.setAlignment(Pos.CENTER_LEFT);
		cardInfoInputBox.setSpacing(10);
		
		VBox cardTypeBox = new VBox(cardTypeInputLabel, cardTypeInputBox, cardEffectInputLabel);
		cardTypeBox.setAlignment(Pos.CENTER_LEFT);
		cardInfoInputBox.setSpacing(10);
		
		VBox cardEffectBox = new VBox(cardEffectInputLabel, cardUnplayableInputBox, cardExhaustInputBox, cardEtheralInputBox, cardInnateInputBox, cardRetainInputBox);
		cardEffectBox.setAlignment(Pos.CENTER_LEFT);
		cardEffectBox.setSpacing(5);
		
		VBox cardOtherOptionsBox = new VBox(cardColorInputLabel, cardColorInputBox, cardRarityInputLabel, cardRarityInputBox);
		cardOtherOptionsBox.setAlignment(Pos.CENTER_LEFT);
		cardOtherOptionsBox.setSpacing(10);
		
		/////////////////////// BOX CREATION //////////////////////////////////
		
		/////////////////////// PANE CREATION //////////////////////////////////
		
		GridPane mainPane = new GridPane();
		mainPane.setPadding(new Insets(10,10,10,10));
		mainPane.setMinSize(600, 750);
		mainPane.setVgap(10);
		mainPane.add(logoBox, 0, 0);
		mainPane.add(cardInfoInputBox, 0, 1);
		mainPane.add(cardTypeBox, 0, 2);
		mainPane.add(cardEffectBox, 0, 3);
		mainPane.add(cardOtherOptionsBox, 0, 4);
		
		/////////////////////// PANE CREATION //////////////////////////////////
		
		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) 
	{

		launch(args);

	}

}
