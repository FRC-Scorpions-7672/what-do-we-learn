package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot {
  
  private DifferentialDrive robot;
  private Joystick joy;
  
  
  @Override
  public void robotInit() {
    robot = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(1));
    joy = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    //robot.tankDrive(joy.getX(), joy.getY());
    robot.arcadeDrive(joy.getThrottle(), joy.getTwist());
    //ana hız kontrolü throttle ile yapılıyor
    //bu haliyle alt şaseyi hareket ettirmek için yeterli
  }


}
