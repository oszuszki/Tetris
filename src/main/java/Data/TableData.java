package Data;


import javafx.beans.property.SimpleStringProperty;

public class TableData {
    private SimpleStringProperty dataPlayer;
    private SimpleStringProperty dataScore;
    private SimpleStringProperty dataLevel;

    public TableData(String dataPlayer, String dataScore, String dataLevel) {
        this.dataPlayer = new SimpleStringProperty(dataPlayer);
        this.dataScore = new SimpleStringProperty(dataScore);
        this.dataLevel = new SimpleStringProperty(dataLevel);
    }

    public String getDataPlayer() {
        return dataPlayer.get();
    }

    public void setDataPlayer(String dataPlayer) {
        this.dataPlayer = new SimpleStringProperty(dataPlayer);
    }

    public String getDataScore() {
        return dataScore.get();
    }

    public void setDataScore(String dataScore) {
        this.dataScore = new SimpleStringProperty(dataScore);
    }

    public String getDataLevel() {
        return dataLevel.get();
    }

    public void setDataLevel(String dataLevel) {
        this.dataLevel = new SimpleStringProperty(dataLevel);
    }
}
