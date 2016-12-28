package com.aohuan.dodo.orm;

import android.app.Application;

import org.xutils.DbManager;

import org.xutils.x;
/**
 * Created by dodo_lihao on 2016/12/27.
 * qq: 2390183798
 */
public class App extends Application {
    private static DbManager.DaoConfig daoConfig;

    @Override
    public void onCreate() {
        super.onCreate();
//        getConfig();
        x.Ext.init(this);
    }


    public static DbManager.DaoConfig getConfig(){
        if(daoConfig == null){
            daoConfig = new DbManager.DaoConfig()
//                    .setDbName("test.db")
//                            // 不设置dbDir时, 默认存储在app的私有目录.
//                    .setDbDir(new File("/sdcard")) // "sdcard"的写法并非最佳实践, 这里为了简单, 先这样写了.
//                    .setDbVersion(2)
//                    .setDbOpenListener(new DbManager.DbOpenListener() {
//                        @Override
//                        public void onDbOpened(DbManager db) {
//                            // 开启WAL, 对写入加速提升巨大
//                            db.getDatabase().enableWriteAheadLogging();
//                        }
//                    })
//                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
//                        @Override
//                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
//                            // TODO: ...
//                            // db.addColumn(...);
//                            // db.dropTable(...);
//                            // ...
//                            // or
//                            // db.dropDb();
//                        }
//                    })
            ;
        }
        return daoConfig;
    }

}
