package com.example.meepmeeptesting;
import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.core.colorscheme.ColorScheme;
import org.rowlandhall.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import org.rowlandhall.meepmeep.core.colorscheme.scheme.ColorSchemeBlueLight;
import org.rowlandhall.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting
{
    static MeepMeep meepMeep;
    static final double TILE = 24;

    static Pose2d beginPoseYellow = new Pose2d(-TILE + -TILE / 2,-2 * TILE + -TILE / 2, Math.toRadians(90));
    static Pose2d samplePosYellow = new Pose2d(beginPoseYellow.getX()+TILE/6, beginPoseYellow.getY()+TILE+TILE/2);

    static Pose2d beginPoseRed = new Pose2d(2 * TILE,-2 * TILE + -TILE / 2, Math.toRadians(90));

    public static void main(String[] args)
    {
        meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity BotRedAllianceRed = redAllianceRedNew();
        RoadRunnerBotEntity BotRedAllianceYellow = redAllianceYellowNewNew();

        RoadRunnerBotEntity BotBlueAllianceBlue = blueAllianceBlue();
        RoadRunnerBotEntity BotBlueAllianceYellow = blueAllianceYellow();

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(BotRedAllianceYellow)
                .addEntity(BotRedAllianceRed)
                .addEntity(BotBlueAllianceBlue)
                .addEntity(BotBlueAllianceYellow)
                .setShowFPS(true)
                .start();
    }

    private static RoadRunnerBotEntity blueAllianceYellow()
    {
        return new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 12.5)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-beginPoseYellow.getX(), -beginPoseYellow.getY(), Math.toRadians(225))) // Mirrored start pose
                        .splineToLinearHeading(new Pose2d(2 * TILE, 2 * TILE, Math.toRadians(225)), Math.toRadians(0))
                        .waitSeconds(1.5)

                        .splineToLinearHeading(new Pose2d(2 * TILE, 1.75 * TILE, Math.toRadians(270)), Math.toRadians(0))
                        .waitSeconds(1.5)
                        .splineToLinearHeading(new Pose2d(2 * TILE, 2 * TILE, Math.toRadians(225)), Math.toRadians(0))
                        .waitSeconds(1.5)

                        .splineToLinearHeading(new Pose2d(2 * TILE, 1.75 * TILE, Math.toRadians(240)), Math.toRadians(0))
                        .waitSeconds(1.5)
                        .splineToLinearHeading(new Pose2d(2 * TILE, 2 * TILE, Math.toRadians(225)), Math.toRadians(0))
                        .waitSeconds(1.5)

                        .splineToLinearHeading(new Pose2d(2.1 * TILE, 1.5 * TILE, Math.toRadians(205)), Math.toRadians(0))
                        .waitSeconds(1.5)
                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(2 * TILE, 2 * TILE, Math.toRadians(225)), Math.toRadians(0))
                        .waitSeconds(1.5)

                        .setTangent(Math.toRadians(270))
                        .splineToLinearHeading(new Pose2d(-beginPoseYellow.getX() - TILE / 3, -beginPoseYellow.getY() - 2 * TILE - TILE / 6, Math.toRadians(180)), Math.toRadians(180))
                        .waitSeconds(3.5)
                        .setTangent(Math.toRadians(0))
                        .splineToLinearHeading(new Pose2d(2 * TILE, 2 * TILE, Math.toRadians(225)), Math.toRadians(90))
                        .waitSeconds(1.5)
                        .setTangent(Math.toRadians(270))
                        .splineToLinearHeading(new Pose2d(-beginPoseYellow.getX() - TILE / 3, -beginPoseYellow.getY() - 2 * TILE - TILE / 6, Math.toRadians(180)), Math.toRadians(180))
                        .build()
                );
    }

    private static RoadRunnerBotEntity blueAllianceBlue()
    {
        return new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 12.5)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-beginPoseRed.getX(), -beginPoseRed.getY(), Math.toRadians(270))) // Mirrored start pose
                        .splineToLinearHeading(new Pose2d(0, 1.5 * TILE, Math.toRadians(270)), Math.toRadians(270))
                        .waitSeconds(1.5)
                        .setTangent(Math.toRadians(120))

                        .splineToLinearHeading(new Pose2d(-1.5 * TILE, 0.5 * TILE, Math.toRadians(90)), Math.toRadians(270))
                        .lineToLinearHeading(new Pose2d(-1.5 * TILE - 0.3 * TILE, 0.5 * TILE, Math.toRadians(90)))
                        .lineToLinearHeading(new Pose2d(-1.5 * TILE - 0.3 * TILE, 2 * TILE, Math.toRadians(90)))

                        .setTangent(Math.toRadians(270))
                        .splineToLinearHeading(new Pose2d(-2 * TILE - 0.3 * TILE, 0.5 * TILE, Math.toRadians(90)), Math.toRadians(180))
                        .setTangent(Math.toRadians(225))
                        //.strafeLeft(0.3 * TILE)
                        .forward(1.5 * TILE)

                        .setTangent(Math.toRadians(270))
                        .splineToLinearHeading(new Pose2d(-2.25 * TILE - 0.3 * TILE, 0.5 * TILE, Math.toRadians(90)), Math.toRadians(180))
                        .setTangent(Math.toRadians(225))
                        //.strafeLeft(0.3 * TILE)
                        .forward(1.5 * TILE)

                        .setTangent(Math.toRadians(320))
                        .splineToLinearHeading(new Pose2d(-TILE * 1.5, TILE * 2, Math.toRadians(90)), Math.toRadians(0))
                        .waitSeconds(1)

                        .splineToLinearHeading(new Pose2d(0, 1.5 * TILE, Math.toRadians(270)), Math.toRadians(270))
                        .waitSeconds(1.5)

                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(-TILE * 1.5, TILE * 2, Math.toRadians(90)), Math.toRadians(90))
                        .waitSeconds(1)

                        .setTangent(Math.toRadians(320))
                        .splineToLinearHeading(new Pose2d(0, 1.5 * TILE, Math.toRadians(270)), Math.toRadians(270))
                        .waitSeconds(1.5)

                        /*
                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(-TILE * 1.5, TILE * 2, Math.toRadians(90)), Math.toRadians(90))
                        .waitSeconds(1.5)

                        .setTangent(Math.toRadians(320))
                        .splineToLinearHeading(new Pose2d(0, 1.5 * TILE, Math.toRadians(270)), Math.toRadians(270))
                        .waitSeconds(1.5)
                        */

                        .addTemporalMarker(() -> {}) // park
                        .setTangent(90)
                        .splineToLinearHeading(new Pose2d(-beginPoseRed.getX() + TILE * 0.2, -beginPoseRed.getY() - TILE * 0.1, Math.toRadians(90)), Math.toRadians(90))

                        .build()
                );

    }

    private static RoadRunnerBotEntity redAllianceYellowNewNew()
    {
        return new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(60,60, Math.toRadians(180), Math.toRadians(180), 12.5)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-TILE + -TILE / 2,-2 * TILE + -TILE / 2, Math.toRadians(90)))
                        .splineToLinearHeading(new Pose2d(-2*TILE, -2*TILE, Math.toRadians(225)), Math.toRadians(180))
                        .waitSeconds(1.5)

                        .splineToLinearHeading(new Pose2d(-2*TILE, -1.75*TILE, Math.toRadians(90)), Math.toRadians(180))
                        .waitSeconds(1.5)
                        .splineToLinearHeading(new Pose2d(-2*TILE, -2*TILE, Math.toRadians(225)), Math.toRadians(180))
                        .waitSeconds(1.5)

                        .splineToLinearHeading(new Pose2d(-2*TILE, -1.75*TILE, Math.toRadians(120)), Math.toRadians(180))
                        .waitSeconds(1.5)
                        .splineToLinearHeading(new Pose2d(-2*TILE, -2*TILE, Math.toRadians(225)), Math.toRadians(180))
                        .waitSeconds(1.5)

                        .setTangent(Math.toRadians(0))
                        .splineToLinearHeading(new Pose2d(-2.1*TILE, -1.5*TILE, Math.toRadians(145)), Math.toRadians(180))
                        .waitSeconds(1.5)
                        .setTangent(Math.toRadians(0))
                        .splineToLinearHeading(new Pose2d(-2*TILE, -2*TILE, Math.toRadians(225)), Math.toRadians(180))
                        .waitSeconds(1.5)

                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(beginPoseYellow .getX()/3 - TILE/2, beginPoseYellow .getY() + 2 * TILE + TILE/6, Math.toRadians(0)), Math.toRadians(0))
                        .build()
                );
    }

    private static RoadRunnerBotEntity redAllianceRedNew()
    {
        return new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(70,70, Math.toRadians(180), Math.toRadians(180), 12.5)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(beginPoseRed)


                        .splineToLinearHeading(new Pose2d(0,-1.5*TILE, Math.toRadians(90)), Math.toRadians(90))
                        .waitSeconds(1.5)
                        .setTangent(Math.toRadians(300))

                        .splineToLinearHeading(new Pose2d(1.5*TILE,-0.5*TILE, Math.toRadians(270)), Math.toRadians(90))
                        .lineToLinearHeading(new Pose2d(1.5*TILE + 0.3*TILE, -0.5*TILE, Math.toRadians(270)))
                        .lineToLinearHeading(new Pose2d(1.5*TILE + 0.3*TILE , -2*TILE, Math.toRadians(270)))

                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(2*TILE+0.3*TILE,-0.5*TILE, Math.toRadians(270)), Math.toRadians(0))
                        .setTangent(Math.toRadians(45))
                        //.strafeRight(0.3*TILE)
                        .forward(1.5*TILE)

                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(2.25*TILE+0.3*TILE,-0.5*TILE, Math.toRadians(270)), Math.toRadians(0))
                        .setTangent(Math.toRadians(45))
                                //.strafeRight(0.3*TILE)
                        .forward(1.5*TILE)

                        .setTangent(Math.toRadians(140))
                        .splineToLinearHeading(new Pose2d(TILE*1.5,-TILE*2,Math.toRadians(270)), Math.toRadians(180))
                        .waitSeconds(1)

                        .splineToLinearHeading(new Pose2d(0,-1.5*TILE, Math.toRadians(90)), Math.toRadians(90))
                        .waitSeconds(1.5)

                        .setTangent(Math.toRadians(0))
                        .splineToLinearHeading(new Pose2d(TILE*1.5,-TILE*2,Math.toRadians(270)), Math.toRadians(270))
                        .waitSeconds(1)

                        .setTangent(Math.toRadians(140))
                        .splineToLinearHeading(new Pose2d(0,-1.5*TILE, Math.toRadians(90)), Math.toRadians(90))
                        .waitSeconds(1.5)
/*

                        .setTangent(Math.toRadians(0))
                        .splineToLinearHeading(new Pose2d(TILE*1.5,-TILE*2,Math.toRadians(270)), Math.toRadians(270))
                        .waitSeconds(1.5)

                        .setTangent(Math.toRadians(140))
                        .splineToLinearHeading(new Pose2d(0,-1.5*TILE, Math.toRadians(90)), Math.toRadians(90))
                        .waitSeconds(1.5)
*/

                        .addTemporalMarker(() -> {}) // park
                        .setTangent(270)
                        .splineToLinearHeading(new Pose2d(beginPoseRed.getX()-TILE*0.2, beginPoseRed.getY()+TILE*0.1, Math.toRadians(270)), Math.toRadians(270))

                        .build()
                );
    }

}