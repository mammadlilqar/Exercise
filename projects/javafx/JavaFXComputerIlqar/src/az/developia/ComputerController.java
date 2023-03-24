package az.developia;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.controlsfx.control.Notifications;

import az.developia.repository.CompRepository;
import az.developia.service.CompService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class ComputerController implements Initializable {
	private boolean updateMode = false;
	private int selectedId = 0;
	CompService compService = new CompService();
	@FXML
	private TextField compMarka, compModel, compPrice, compMemorySize, compRam, compColor, compProcessor,
			compScreenSize;
	@FXML
	private TableColumn<Computers, Integer> idColumn;
	@FXML
	private TableView<Computers> compTable;
	@FXML
	private TableColumn<Computers, String> markaColumn;
	@FXML
	private TableColumn<Computers, String> modelColumn;
	@FXML
	private TableColumn<Computers, Integer> priceColumn;
	@FXML
	private TableColumn<Computers, String> memoryColumn;
	@FXML
	private TableColumn<Computers, Integer> ramColumn;
	@FXML
	private TableColumn<Computers, String> colorColumn;
	@FXML
	private TableColumn<Computers, String> processorColumn;
	@FXML
	private TableColumn<Computers, String> screenSizeColumn;

	public void saveData() {
		String marka = compMarka.getText();
		if (marka.length() > 14 || marka.length() < 2) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj")
					.text("Simvol sayı maksimum 14,minimum 2 dir.").show();
			return;
		}
		String model = compModel.getText();
		String Price = compPrice.getText();
		if (Price.length() == 0) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Bu hissəni boş qoymayın.")
					.show();
			return;
		}
		int price = Integer.valueOf(Price);

		String memory = compMemorySize.getText();
		String Ram = compRam.getText();
		if (Ram.length() == 0) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Bu hissəni boş qoymayın.")
					.show();
			return;
		}
		int ram = Integer.valueOf(Ram);
		String color = compColor.getText();
		String processor = compProcessor.getText();
		String screenSize = compScreenSize.getText();

		Computers computers = new Computers();
		computers.setMarka(marka);
		computers.setModel(model);
		computers.setPrice(price);
		computers.setMemorySize(memory);
		computers.setRam(ram);
		computers.setColor(color);
		computers.setProcessor(processor);
		computers.setScreenSize(screenSize);
if(updateMode) {
	computers.setId(selectedId);
	CompService.update(computers);
	updateMode=false;
}else {
		compService.add(computers);
}
	
	
		compMarka.setText("");
		compModel.setText("");
		compPrice.setText("");
		compMemorySize.setText("");
		compRam.setText("");
		compColor.setText("");
		compProcessor.setText("");
		compScreenSize.setText("");
	showALL();

	}

	private void showALL() {
		ObservableList<Computers> list = FXCollections.observableArrayList();
		list.addAll(compService.findAll());
		compTable.setItems(list);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		markaColumn.setCellValueFactory(new PropertyValueFactory<>("Marka"));
		modelColumn.setCellValueFactory(new PropertyValueFactory<>("Model"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
		memoryColumn.setCellValueFactory(new PropertyValueFactory<>("MemorySize"));
		ramColumn.setCellValueFactory(new PropertyValueFactory<>("Ram"));
		colorColumn.setCellValueFactory(new PropertyValueFactory<>("Color"));
		processorColumn.setCellValueFactory(new PropertyValueFactory<>("Processor"));
		screenSizeColumn.setCellValueFactory(new PropertyValueFactory<>("ScreenSize"));
		compTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		showALL();
	}

	public void deleteData() {
		List<Computers> selectedComps = compTable.getSelectionModel().getSelectedItems();
		if (selectedComps.size() == 0) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Sətir seçin").show();
			return;
		}
		int a = JOptionPane.showConfirmDialog(null, "Silməyə əminsən?");
		if (a == 0) {
			for (Computers comps : selectedComps) {
				Integer id = comps.getId();
				compService.delete(id);

			}

			showALL();
		}

	}

	public void updateData() {
		Computers selectedComp = compTable.getSelectionModel().getSelectedItem();
		if (selectedComp == null) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Sətir seçin ").show();
			return;

		}
		compMarka.setText(selectedComp.getMarka());
		compModel.setText(selectedComp.getModel());
		int b = selectedComp.getPrice();
		String v = Integer.toString(b);
		compPrice.setText(v);
		compMemorySize.setText(selectedComp.getMemorySize());
		int y = selectedComp.getRam();
		String c = Integer.toString(y);
		compRam.setText(c);
		compColor.setText(selectedComp.getColor());
		compProcessor.setText(selectedComp.getProcessor());
		compScreenSize.setText(selectedComp.getScreenSize());

		selectedId = selectedComp.getId();
		updateMode = true;
	}

}
