package xiao.testscheme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 每个 <data> 元素均可指定 URI 结构和数据类型（MIME 媒体类型）。 URI 的每个部分均包含单独的 scheme、host、port 和 path 属性：
 * <scheme>://<host>:<port>/<path>
 * <p>
 * 例如：
 * <p>
 * content://com.example.project:200/folder/subfolder/etc
 * <p>
 * 在此 URI 中，架构是 content，主机是　com.example.project，端口是 200，路径是 folder/subfolder/etc。
 * <p>
 * 在 <data> 元素中，上述每个属性均为可选，但存在线性依赖关系：
 * <p>
 * 如果未指定架构，则会忽略主机。
 * 如果未指定主机，则会忽略端口。
 * 如果未指定架构和主机，则会忽略路径。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_to_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }
}
