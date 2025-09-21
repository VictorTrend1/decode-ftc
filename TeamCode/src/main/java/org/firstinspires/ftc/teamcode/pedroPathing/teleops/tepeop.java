    package org.firstinspires.ftc.teamcode.pedroPathing.teleops;

    import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

    import com.bylazar.configurables.annotations.Configurable;
    import com.bylazar.telemetry.PanelsTelemetry;
    import com.bylazar.telemetry.TelemetryManager;
    import com.pedropathing.follower.Follower;
    import com.pedropathing.geometry.Pose;
    import com.qualcomm.robotcore.eventloop.opmode.OpMode;
    import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

    import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
    import org.firstinspires.ftc.teamcode.pedroPathing.motoare;

    @Configurable
    @TeleOp
    public class tepeop extends OpMode {
        Follower follower;
        public static Pose startingPose;
        private TelemetryManager telemetrie;
        private tureta_aim tureta;
        motoare motoare;


        @Override
        public void init() {
            tureta = new tureta_aim();
            follower = Constants.createFollower(hardwareMap);
            follower.setStartingPose(startingPose == null ? new Pose() : startingPose);
            follower.update();
            telemetrie = PanelsTelemetry.INSTANCE.getTelemetry();
            motoare = new motoare(hardwareMap);

        }
        @Override
        public void start(){
            follower.startTeleopDrive();
        }
        @Override
        public void loop(){
            Pose pozitie = follower.getPose();

            follower.update();
            telemetrie.update();
            follower.setTeleOpDrive(
                    -gamepad1.left_stick_y,
                    -gamepad1.left_stick_x,
                    -gamepad1.right_stick_x,
                    true
            );
            tureta.aiming(motoare.tureta,Constants.xtarget_red, Constants.ytarget_red, pozitie);
            telemetrie.debug("pozitie motor: ", motoare.tureta.getCurrentPosition());
            telemetrie.debug("pozitie: ", follower.getPose());
            telemetrie.debug("acceleratie: ", follower.getVelocity());
        }
    }
