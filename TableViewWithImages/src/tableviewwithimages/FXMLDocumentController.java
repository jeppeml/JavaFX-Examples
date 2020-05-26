/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewwithimages;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Jeppe
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TableView<Person> tbl;
    @FXML
    private TableColumn<Person, Integer> c1;
    @FXML
    private TableColumn<Person, ImageView> c2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Converts the integer value to an Image shown in the table
        // We override the CellValueFactory, as it now returns an Observable<ImageView>
        // achieved by using a lambda expression to map from integer to imageview
        c2.setCellValueFactory((cell) -> { // cell is the cells properties (CellDataFeatures)
            URL urlToUse = getClass().getResource("500Dollar.jpg");
            if (cell.getValue().getAtWork() == 0) {
                urlToUse = getClass().getResource("1Dollar.jpg");
            }
            Image img = new Image(urlToUse.toString(), 50, 50, true, true); // Resize the image to fit 50x50 max
            return new SimpleObjectProperty<>(new ImageView(img)); // Translate the ImageView to an Observable<ImageView>
        });

        c1.setCellValueFactory((param) -> {
            return param.getValue().idProperty().asObject();
        });

        Person p0 = new Person(0, 1);
        Person p1 = new Person(1, 0);
        Person p2 = new Person(2, 1);
        Person p3 = new Person(3, 1);

        tbl.getItems().add(p0);
        tbl.getItems().add(p1);
        tbl.getItems().add(p2);
        tbl.getItems().add(p3);
    }

}
