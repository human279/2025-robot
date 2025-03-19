package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Climber extends Command {
    
    private int mode;
    private double speed;
    private VictorSPX algaeElevatorMotor;
    public Climber(int mode){
        this.mode = mode;
        algaeElevatorMotor = new VictorSPX(3);
    }
    
    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (mode==0){ // intake
        speed = .5; 
        System.out.println("mode set to 0, climbUP");
    }
    if (mode == 1){
        speed = -.5;
        System.out.println("mode set to 1, climbDown");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    algaeElevatorMotor.set(ControlMode.PercentOutput,speed);
    //cancel();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    algaeElevatorMotor.set(ControlMode.PercentOutput,0);
    System.out.println("stop climb");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


}
