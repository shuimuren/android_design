package com.design.andoid.lhj.android_design.msgctrl;/** * Created by lhj on 18/5/8 */public class ControllerRegister {    public  ControllerRegister() {    }    public static void initialize(){        initUpgradeController();        initRequestController();        initShareController();    }    private static void initUpgradeController() {        initController(ControllerId.UPGRADE_CONTROLLER, new int[]{                MsgDef.MSG_DEF_AUTO_CHECK_UPGRADE,                MsgDef.MSG_DEF_MANUALLY_CHECK_UPGRADE        });    }    private static void initRequestController(){        initController(ControllerId.REQUEST_CONTROLLER,new int[]{                MsgDef.MSG_DEF_USER_INFO,                //... 所有请求数据相关都在这里注册                MsgDef.MSG_DEF_GET_USER_INFO        });    }    private static void initShareController() {        //TODo 处理微信分享相关请求    }    private static void initController(int controllerId,int[] msgIds){        MsgDispatcher.register(controllerId,msgIds);    }}