/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.button.JoyStickButton;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  public static final int kMotorPort = 0;
  public static final int kJoyStick = 0;
  public static final int kInputPort = 0;

  private SpeedController m_motor;
  private JoyStick m_joystick;
  private JoyStickButton m_button1;
  private JoyStickButton m_button2;
  private DigitalInput input;


  @Override
  public void robotInit() {
    m_motor = new PWMVictorSPX(kMotorPort);
    m_joystick = new JoyStick(kJoyStick);
    m_button1 = new JoyStickButton(m_joystick, 1); //the button with no.1 in joystick
    m_button2 = new JoyStickButton(m_joystick, 2);
    input = new DigitalInput(kInputPort);
  }

 @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    while(input.get()){
        if(m_button1.get()){
          m_motor.set(0.5);
        }
        else if(m_button2.get()){
          m_motor.set(-0.5);
        }
        else{
          m_motor.set(0);
        }
    }
  
  }

}


//ground = şase