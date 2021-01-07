package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.button.JoyStickButton;
import edu.wpi.first.wpilibj.DigitalInput;

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
    m_button1 = new JoyStickButton(m_joystick, 1); 
    m_button2 = new JoyStickButton(m_joystick, 2);
    input = new DigitalInput(kInputPort);
  }

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

