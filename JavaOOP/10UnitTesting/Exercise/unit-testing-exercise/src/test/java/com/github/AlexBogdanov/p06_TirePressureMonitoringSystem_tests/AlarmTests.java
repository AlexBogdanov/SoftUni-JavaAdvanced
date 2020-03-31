package com.github.AlexBogdanov.p06_TirePressureMonitoringSystem_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.AlexBogdanov.p06_TirePressureMonitoringSystem.Alarm;
import com.github.AlexBogdanov.p06_TirePressureMonitoringSystem.Sensor;

import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTests {

    @Test
    public void check_shoud_set_alarmOn_to_false_if_pressure_is_in_bounds() {
        // GIVEN
        var sensorMock = Mockito.mock(Sensor.class);
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(19.0);
        var alarm= new Alarm(sensorMock);

        // WHEN
        alarm.check();

        // THEN
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void check_shoud_set_alarmOn_to_true_if_pressure_is_too_low() {
        // GIVEN
        var sensorMock = Mockito.mock(Sensor.class);
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(12.0);
        var alarm= new Alarm(sensorMock);

        // WHEN
        alarm.check();

        // THEN
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void check_shoud_set_alarmOn_to_true_if_pressure_is_too_high() {
        // GIVEN
        var sensorMock = Mockito.mock(Sensor.class);
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(30.0);
        var alarm= new Alarm(sensorMock);

        // WHEN
        alarm.check();

        // THEN
        assertTrue(alarm.getAlarmOn());
    }

}
