package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class AlgaeIntake extends Command{
    //public VictorSPX left1Motor   = new VictorSPX(7);
    private VictorSPX algaeMotor;
    private int mode = 0;
    private double speed = 0;

    public AlgaeIntake(int mode){
        algaeMotor = new VictorSPX(0);
        this.mode = mode;
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (mode==0){ // intake
        speed = -.5; 
        System.out.println("mode set to 0, intake");
    }
    if (mode == 1){
        speed = .8;
        System.out.println("mode set to 1, outtake");
    }
    if (mode==2){
        speed = 0;
        System.out.println("mode set to 2, off");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    algaeMotor.set(ControlMode.PercentOutput,speed);
    cancel();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

    
    
}
