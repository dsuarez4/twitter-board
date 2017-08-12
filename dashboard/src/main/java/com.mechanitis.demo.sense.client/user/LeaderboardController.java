package com.mechanitis.demo.sense.client.user;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

/**
 * Created by davidsuarez on 7/16/17.
 */
public class LeaderboardController {

    @FXML private TableView<TwitterUser> leaders;

    public void setData(LeaderboardData data) {
        leaders.setItems(data.getItems());
    }
}
