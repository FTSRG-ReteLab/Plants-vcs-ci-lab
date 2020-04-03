package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TrainSensorTest {

    @Mock
    TrainController trainController;

    @Mock
    TrainUser trainUser;

    @InjectMocks
    TrainSensor trainSensor =  new TrainSensorImpl(this.trainController, this.trainUser);

    @Before
    public void before() {

    }

    @Test
    public void AlarmTest1() {
        trainSensor.overrideSpeedLimit(501);
        verify(this.trainUser).setAlarmState(anyBoolean());
    }

    @Test
    public void AlarmTest2() {
        trainSensor.overrideSpeedLimit(-1);
        verify(this.trainUser).setAlarmState(anyBoolean());
    }

    @Test
    public void AlarmTest3() {
        trainSensor.overrideSpeedLimit(100);
        trainSensor.overrideSpeedLimit(10);
        verify(this.trainUser).setAlarmState(anyBoolean());
    }

    @Test
    public void AlarmTest4() {
        trainSensor.overrideSpeedLimit(10);
        trainSensor.overrideSpeedLimit(15);
        verify(this.trainUser, never()).setAlarmState(anyBoolean());
    }
}
