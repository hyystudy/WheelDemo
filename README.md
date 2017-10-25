# andorid圆盘效果
通过view的ondraw方法
```java
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.translate(width/2, height - 2 * density);

        float startAngle = -180;
        float sweepAngle = 9;
        for (int i = 0; i < 21; i++){
            float startX = (float) (radius * Math.cos(startAngle / 180 * Math.PI));
            float startY = (float) (radius * Math.sin(startAngle / 180 * Math.PI));
            if (i % 5 == 0){
                paint.setColor(Color.BLUE);
                float endX = (float) ((radius - 10 * density) * Math.cos(startAngle / 180 * Math.PI));
                float endY = (float) ((radius - 10 * density) * Math.sin(startAngle / 180 * Math.PI));
                canvas.drawLine(startX, startY, endX, endY, paint);
            }else {
                paint.setColor(Color.BLACK);
                float endX = (float) ((radius - 5 * density) * Math.cos(startAngle / 180 * Math.PI));
                float endY = (float) ((radius - 5 * density) * Math.sin(startAngle / 180 * Math.PI));
                canvas.drawLine(startX, startY, endX, endY, paint);
            }
            startAngle += sweepAngle;
        }
        paint.setColor(Color.BLACK);
        canvas.drawArc(rectF, -180, 180f, false, paint);
    }

```
实现如下效轮盘效果：
![image](https://github.com/hyystudy/WheelDemo/iamges/yuanpan.png)

