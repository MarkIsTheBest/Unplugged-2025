package org.firstinspires.ftc.teamcode.subsystems.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Motors
{
    public static DcMotor leftFront;
    public static DcMotor leftRear;
    public static DcMotor rightFront;
    public static DcMotor rightRear;

    public static DcMotor armLeft;
    public static DcMotor armRight;
    public static DcMotor intakeExtend;
    public static DcMotor intakeRotate;

    public static DcMotor[] allMotors;

    public static void Init(HardwareMap hardwareMap) {
        try
        {
            GetMotors(hardwareMap);
            SetZeroPowerBehaviour();
            SetDirection();
            SetAllMotors();
        }
        catch (Exception ignored) {}
    }

    private static void GetMotors(HardwareMap hardwareMap)
    {
        leftFront = hardwareMap.tryGet(DcMotor.class, "leftFront");
        leftRear = hardwareMap.tryGet(DcMotor.class, "leftBack");
        rightFront = hardwareMap.tryGet(DcMotor.class, "rightFront");
        rightRear = hardwareMap.tryGet(DcMotor.class, "rightBack");

        armLeft = hardwareMap.tryGet(DcMotor.class, "armLeft");
        armRight = hardwareMap.tryGet(DcMotor.class, "armRight");
        intakeExtend = hardwareMap.tryGet(DcMotor.class, "intakeExtend");
        intakeRotate = hardwareMap.tryGet(DcMotor.class, "intakeRotate");
    }

    private static void SetZeroPowerBehaviour()
    {
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        armLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeExtend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeRotate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private static void SetDirection()
    {
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private static void SetAllMotors()
    {
        allMotors[0] = leftFront;
        allMotors[1] = rightFront;
        allMotors[2] = leftRear;
        allMotors[3] = rightRear;

        allMotors[4] = armLeft;
        allMotors[5] = armRight;
        allMotors[6] = intakeExtend;
        allMotors[7] = intakeRotate;
    }

}