package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import java.util.Date;

public class Tachograph {
    private TrainController controller;
    private TrainUser user;

    private Table<Date, Integer, Integer> table = HashBasedTable.create();

    public Tachograph(TrainController controller, TrainUser user) {
        this.controller = controller;
        this.user = user;
    }

    public void saveData(){
        System.out.println("saveData");
        System.out.println("D: " + new Date());
        System.out.println("RS: " + controller.getReferenceSpeed());
        System.out.println("JP: "+ user.getJoystickPosition());
        this.table.put(new Date(), controller.getReferenceSpeed(), user.getJoystickPosition());
    }

    public Boolean isTableEmpty(){
        return this.table.isEmpty();
    }
}
