package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class AlgaeElevator extends Command{
    
    private int mode;
    private double speed;
    private VictorSPX algaeElevatorMotor;
    public AlgaeElevator(int mode){
        this.mode = mode;
        algaeElevatorMotor = new VictorSPX(1);
    }
    
    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (mode==0){ // intake
        speed = 1; 
        System.out.println("elevator up");
    }
    if (mode == 1){
        speed = -1;
        System.out.println("elevator down");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    algaeElevatorMotor.set(ControlMode.PercentOutput,speed);
    /*
     * if limitswitch &&mode==1{
     * cancel()
     * }
     * 
     * 
     */
    //cancel();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    algaeElevatorMotor.set(ControlMode.PercentOutput,0);
    System.out.println("stop algea elevator");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


}
