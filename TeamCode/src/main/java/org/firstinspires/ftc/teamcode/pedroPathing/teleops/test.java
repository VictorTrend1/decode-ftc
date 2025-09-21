package org.firstinspires.ftc.teamcode.pedroPathing.teleops;

import static org.firstinspires.ftc.teamcode.pedroPathing.teleops.tepeop.startingPose;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Configurable
@TeleOp

public class test extends OpMode {
    TelemetryManager telemetrie;
    Follower follower;

    public void init() {
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(startingPose == null ? new Pose() : startingPose);
        follower.update();

        telemetrie = PanelsTelemetry.INSTANCE.getTelemetry();


    }

    @Override
    public void start() {

        follower.startTeleopDrive();
    }

    @Override
    public void loop() {
        telemetrie.debug("position", follower.getPose());
        telemetrie.update();

    }
}
