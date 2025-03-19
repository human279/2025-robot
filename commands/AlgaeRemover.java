package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class AlgaeRemover extends Command{
    //public VictorSPX left1Motor   = new VictorSPX(7);
    private VictorSPX algaeRemoverMotor;
    //private int mode = 0;
    private double speed;
    
    public AlgaeRemover(){
        algaeRemoverMotor = new VictorSPX(2);
        /* 
        if (mode == 0)
            mode =1; 
        
        if (mode == 1)
            mode = 0;*/
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
        speed = .5; 
        System.out.println("mode set to 0, off");
    
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    algaeRemoverMotor.set(ControlMode.PercentOutput,speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    algaeRemoverMotor.set(ControlMode.PercentOutput,0);
    System.out.println("stopped");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

    
    
    
}
