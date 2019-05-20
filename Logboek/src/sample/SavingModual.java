package sample;

import javafx.stage.FileChooser;
import sample.Log.ProjectManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SavingModual {

    private static String saveFileURL = "project.save";

    public static void saveList(ProjectManager projectManager) {
        try (
              ObjectOutputStream output =
                      new ObjectOutputStream(new FileOutputStream(saveFileURL));
        ) {
            output.writeObject(projectManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProjectManager loadSave() {
        try (
                ObjectInputStream input =
                        new ObjectInputStream(new FileInputStream(saveFileURL))
                ) {
            Object inputObject = input.readObject();
            if (inputObject.getClass() == ProjectManager.class) {
                return (ProjectManager) inputObject;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ProjectManager OpenFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open ProjectManager file");
        return null;
    }

    public static void setSaveFileURL(String saveFileURL) {
        SavingModual.saveFileURL = saveFileURL;
    }
}
