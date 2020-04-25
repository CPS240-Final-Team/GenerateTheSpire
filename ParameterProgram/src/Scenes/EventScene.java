package Scenes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Classes.CardParameterPartial;
import Classes.CardParameters;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

//The scene that lets the user enter information about various card events and properties (this class also generates the entire card)

public class EventScene 
{
	SceneController sceneControl = new SceneController();

	public EventScene(CardParameterPartial partialClass) throws FileNotFoundException
	{
		
		/////////////////////// CONTROL CREATION //////////////////////////////////
		
		FileInputStream imageFIS = new FileInputStream("resources/spireLogo.png");
		Image logoImage = new Image(imageFIS);
		ImageView logoView = new ImageView(logoImage);
		
		Label targetInputLabel = new Label("Choose the card's target: ");
		ComboBox<String> targetInputBox = new ComboBox<String>();
		targetInputBox.getItems().add("Player");
		targetInputBox.getItems().add("Enemy");
		targetInputBox.getItems().add("All Enemies");
		targetInputBox.getItems().add("Random Enemy");
		
		CheckBox usesBlockInputBox = new CheckBox("Uses Block");
		CheckBox usesMagicNumberInputBox = new CheckBox("Uses Magic Number");
		CheckBox usesDamageInputBox = new CheckBox("Uses Damage");
		CheckBox thisMagicNumberBox = new CheckBox("Use this.MagicNumber");
		thisMagicNumberBox.setDisable(true);											
		
		Label numberLabel = new Label("Number: ");
		Label amountLabel = new Label("Amount: ");
		
		TextField blockNumberInputField = new TextField();
		blockNumberInputField.setPrefWidth(40);
		blockNumberInputField.setMaxWidth(40);
		blockNumberInputField.setDisable(true);
		
		TextField magicNumberInputField = new TextField();
		magicNumberInputField.setPrefWidth(40);
		magicNumberInputField.setMaxWidth(40);
		magicNumberInputField.setDisable(true);
		
		TextField damageInputField = new TextField();
		damageInputField.setPrefWidth(40);
		damageInputField.setMaxWidth(40);
		damageInputField.setDisable(true);
		
		CheckBox gainBlockInputBox = new CheckBox("Card Gains Block");
		CheckBox damageTargetMonsterInputBox = new CheckBox("Card Damages Target Monster");
		CheckBox applyStatusInputBox = new CheckBox("Card Applies a Status");
		
		ComboBox<String> damageTargetMonsterEffectsInputBox = new ComboBox<String>();
		damageTargetMonsterEffectsInputBox.getItems().add("None");
		damageTargetMonsterEffectsInputBox.getItems().add("Blunt Light");
		damageTargetMonsterEffectsInputBox.getItems().add("Blunt Heavy");
		damageTargetMonsterEffectsInputBox.getItems().add("Slash Diagonal");
		damageTargetMonsterEffectsInputBox.getItems().add("Slash Horizontal");
		damageTargetMonsterEffectsInputBox.getItems().add("Slash Vertical");
		damageTargetMonsterEffectsInputBox.getItems().add("Slash Heavy");
		damageTargetMonsterEffectsInputBox.getItems().add("Smash");
		damageTargetMonsterEffectsInputBox.getItems().add("Fire");
		damageTargetMonsterEffectsInputBox.getItems().add("Poison");
		damageTargetMonsterEffectsInputBox.getItems().add("Shield");
		damageTargetMonsterEffectsInputBox.getItems().add("Lightning");
		damageTargetMonsterEffectsInputBox.setDisable(true);
		
		ComboBox<String> applyStatusOptionsInputBox = new ComboBox<String>();
		applyStatusOptionsInputBox.getItems().add("My Lumps");
		applyStatusOptionsInputBox.getItems().add("HIGH hoeps");
		applyStatusOptionsInputBox.getItems().add("Joker Fom Persona 5");
		applyStatusOptionsInputBox.setDisable(true);
		
		Label applyStatusStacksLabel = new Label("Stack Amount: ");
		
		TextField applyStatusStacksInputField = new TextField();
		applyStatusStacksInputField.setPrefWidth(40);
		applyStatusStacksInputField.setMaxWidth(40);
		applyStatusStacksInputField.setDisable(true);
		
		Label statusLabel = new Label("");
		statusLabel.setTextFill(Paint.valueOf(Color.ORANGERED.toString()));
		
		Button generateCardButton = new Button("Generate Card");
		generateCardButton.setTextFill(Paint.valueOf("#ffffff"));
		generateCardButton.setStyle("-fx-base: rgb(30,170,255);");
		
		/////////////////////// CONTROL CREATION //////////////////////////////////
		
		/////////////////////// BOX CREATION //////////////////////////////////
		
		HBox logoBox = new HBox(logoView);
		logoBox.setAlignment(Pos.CENTER);
		
		VBox targetBox = new VBox(targetInputLabel, targetInputBox);
		targetBox.setAlignment(Pos.CENTER);
		
		BorderPane logoTargetPane = new BorderPane();
		logoTargetPane.setTop(logoBox);
		logoTargetPane.setCenter(targetBox);
		logoTargetPane.setMinSize(500, 100);
		
		HBox blockBox = new HBox(usesBlockInputBox, amountLabel, blockNumberInputField);
		blockBox.setSpacing(20);
		HBox magicBox = new HBox(usesMagicNumberInputBox, numberLabel, magicNumberInputField, thisMagicNumberBox);
		magicBox.setSpacing(20);
		HBox damageBox = new HBox(usesDamageInputBox, amountLabel, damageInputField);
		damageBox.setSpacing(20);
		HBox damage2Box = new HBox(damageTargetMonsterInputBox, damageTargetMonsterEffectsInputBox);
		damage2Box.setSpacing(20);
		HBox statusBox = new HBox(applyStatusInputBox, applyStatusOptionsInputBox, applyStatusStacksLabel, applyStatusStacksInputField);
		statusBox.setSpacing(20);
		HBox statusLabelBox = new HBox(statusLabel);
		statusLabelBox.setAlignment(Pos.CENTER);
		HBox generateButtonBox = new HBox(generateCardButton);
		generateButtonBox.setAlignment(Pos.CENTER);
		VBox statusButtonBox = new VBox(statusLabelBox, generateButtonBox);
		
		
		/////////////////////// BOX CREATION //////////////////////////////////
		
		/////////////////////// PANE CREATION //////////////////////////////////
		
		GridPane eventsPane = new GridPane();
		eventsPane.add(blockBox, 1, 0);
		eventsPane.add(magicBox, 1, 1);
		eventsPane.add(damageBox, 1, 2);
		eventsPane.add(damage2Box, 1, 3);
		eventsPane.add(statusBox, 1, 4);
		eventsPane.setVgap(10);
		eventsPane.setHgap(10);
		eventsPane.setMinSize(500, 200);
		
		BorderPane generalPane = new BorderPane();
		generalPane.setTop(logoTargetPane);
		generalPane.setCenter(eventsPane);
		generalPane.setBottom(statusButtonBox);
		generalPane.setMargin(statusButtonBox, new Insets(10, 10, 40, 10));
		generalPane.setMargin(eventsPane, new Insets(50,40,10,10));
		generalPane.setMinSize(600, 300);
		generalPane.setStyle("-fx-background-color: #D3D3D3; ");
		
		Scene eventScene = new Scene(generalPane);
		
		/////////////////////// PANE CREATION //////////////////////////////////
		
		/////////////////////// CONTROL EVENT HANDLING ///////////////////////////
		
		usesBlockInputBox.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent e)
			{
				if(usesBlockInputBox.isSelected())
				{
					blockNumberInputField.setDisable(false);		//if block number is being used, re-enable field
				}
				else
				{
					blockNumberInputField.setDisable(true);			//don't let the user input a block number if it's not being used 
				}
						
			}
			
		});
		
		usesMagicNumberInputBox.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent e) 
			{
				if(usesMagicNumberInputBox.isSelected())
				{
					magicNumberInputField.setDisable(false);	//if magic number is being used, re-enable field and box
					thisMagicNumberBox.setDisable(false);		
				}
				else
				{
					magicNumberInputField.setDisable(true);		//don't let the user input a magic number if it's not being used 
					thisMagicNumberBox.setDisable(true);		//don't let the user choose this.magic number if it's not being used 
				}
				
			}
			
		});
		
		thisMagicNumberBox.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent e) 
			{
				if(thisMagicNumberBox.isSelected())
				{
					magicNumberInputField.setDisable(true);		//if it's not being used, let them enter a number
				}
				else
				{
					magicNumberInputField.setDisable(false);	//if this.magicNumber is being used, don't let the user enter a magic number
				}
				
			}
			
		});
		
		usesDamageInputBox.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent e) 
			{
				if(usesDamageInputBox.isSelected())
				{
					damageInputField.setDisable(false);				
				}
				else
				{
					damageInputField.setDisable(true);
				}
				
			}
			
		});
		
		damageTargetMonsterInputBox.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent e) 
			{
				if(damageTargetMonsterInputBox.isSelected())
				{
					damageTargetMonsterEffectsInputBox.setDisable(false);				//if damage is being used, let the user choose effects
				}
				else
				{
					damageTargetMonsterEffectsInputBox.setDisable(true);
				}
				
			}
			
		});
		
		applyStatusInputBox.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent e)
			{
				if(applyStatusInputBox.isSelected())
				{
					applyStatusOptionsInputBox.setDisable(false);						//if apply status is being used, let the user choose a status and number of stacks
					applyStatusStacksInputField.setDisable(false);
				}
				else
				{
					applyStatusOptionsInputBox.setDisable(true);
					applyStatusStacksInputField.setDisable(true);
				}
				
			}
			
			
		});
		
		generateCardButton.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent e)
			{
				Boolean numberFormatsCorrect = true;								//a boolean to check that all the text in every textfield is only numbers
				
				if(usesBlockInputBox.isSelected())									//check if only an integer was entered, only if block is being used
				{
					try
					{
						Integer.parseInt(blockNumberInputField.getText());
					}
					catch (Exception exceptArg)
					{
						statusLabel.setText("The block amount must be an integer.");
						numberFormatsCorrect = false;
					}
				}
				
				if(usesMagicNumberInputBox.isSelected())							//check if only an integer was entered, only if magic number is being used
				{
					try
					{
						Integer.parseInt(magicNumberInputField.getText());
					}
					catch (Exception exceptArg)
					{
						statusLabel.setText("The magic number must be an integer.");
						numberFormatsCorrect = false;
					}
				}
				
				
				if(usesDamageInputBox.isSelected())									//check if only an integer was entered, only if damage is being used
				{
					try
					{
						Integer.parseInt(damageInputField.getText());
					}
					catch (Exception exceptArg)
					{
						statusLabel.setText("The damage amount must be an integer.");
						numberFormatsCorrect = false;
					}
				}
				
				if(applyStatusInputBox.isSelected())								//check if only an integer was entered, only if apply status effects is being used
				{
					try
					{
						Integer.parseInt(applyStatusStacksInputField.getText());
					}
					catch (Exception exceptArg)
					{
						statusLabel.setText("The stacks amount must be an integer.");
						numberFormatsCorrect = false;
					}
				}
				
			
				
				if(numberFormatsCorrect)
				{
					statusLabel.setText("");
					CardParameters newCard = new CardParameters(partialClass.getID(), partialClass.getCardName(), partialClass.getCardDescription(), partialClass.getCardCost(), partialClass.getCardType(), partialClass.getCardSpecialEffects(), partialClass.getCardColor(), partialClass.getCardRarity(), usesBlockInputBox.isSelected(), usesMagicNumberInputBox.isSelected(), usesDamageInputBox.isSelected(), Integer.parseInt(blockNumberInputField.getText()), Integer.parseInt(magicNumberInputField.getText()), Integer.parseInt(damageInputField.getText()));
				}
			}
			
		});
		
		/////////////////////// CONTROL EVENT HANDLING ///////////////////////////
		
		sceneControl.getMainStage().setScene(eventScene);			//get global stage and set it to this scene
		sceneControl.getMainStage().show();							//show this scene
		
	}
	
}
