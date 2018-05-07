package com.bookshop.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateCode {
	// 输出一张随机验证码图片
	public static final int WIDTH = 160;
	public static final int HEIGHT = 50;
	//生成验证码
	public static HttpServletResponse generateValidateCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// 1.設置背景色
		setBackGround(g);
		// 2.設置邊框
		setBorder(g);
		// 3.画干扰线
		drawRandomLine(g);
		// 4.写随机数
		String random = drawRandomNum((Graphics2D) g);
		// 写给客户机的同时也给服务器一份,将验证码存到session中
		request.getSession().setAttribute("imagecheckcode", random);
		// 5.把图形写给浏览器
		// 通知浏览器以图形的方式打开
		response.setContentType("image/jpeg");
		// 发头控制浏览器不要缓存
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//将图像输出到Servlet输出流中。
		ImageIO.write(image, "jpg", response.getOutputStream());
		return response;
	}
	
	private static String drawRandomNum(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(123 ,104 ,238));
		g.setFont(new Font("宋体", Font.BOLD, 40));
		// 所有的汉字都在Unicode【\u4e00--\u9fa5】区间,所有的中文都是以Unicode码存进去的。所以char c =
		// '\u4e00',相当于char c='一'

		String base = "\u0051\u0057\u0045\u0052\u0054\u0059\u0055\u0049\u004f\u0050\u0041\u0053\u0044\u0046\u0047\u0048\u004a\u004b\u004c\u005a\u0058\u0043\u0056\u0042\u004e\u004d"
				+ "\u0071\u0077\u0065\u0072\u0074\u0079\u0075\u0069\u006f\u0070\u0061\u0073\u0064\u0066\u0067\u0068\u006a\u006b\u006c\u007a\u0078\u0063\u0076\u0062\u006e\u006d"
				+ "\u0031\u0032\u0033\u0034\u0035\u0036\u0037\u0038\u0039\u0030";
		StringBuffer sb = new StringBuffer();
		int x = 14;
		for (int i = 0; i < 4; i++) {
			int degree = new Random().nextInt() % 30;// 求30余数，返回负30到正30的随机数。
			String ch = base.charAt(new Random().nextInt(base.length())) + "";// 加完“
			sb.append(ch); // ”之后就有char类型转换为string类型了。
			g.rotate(degree * Math.PI / 180, x, 35);// 设置旋转的角度，弧度制的
			g.drawString(ch, x, 35);
			g.rotate(-degree * Math.PI / 180, x, 35);// 把旋转后的字再旋转回去了，要不然一直循环，角度会一直跟着变大。注意字会旋转出验证码所在的框。
			x += 40;

		}
		return sb.toString();
	}

	private static void drawRandomNum2(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		// 所有的汉字都在Unicode【\u4e00--\u9fa5】区间,所有的中文都是以Unicode码存进去的。所以char c =
		// '\u4e00',相当于char c='一'
		String base = "看不清，换一张";
		g.drawString(base, 14, 30);
	}

	
	private static void drawRandomLine(Graphics g) {
		// TODO Auto-generated method stub
		Color[] colors = {new Color(126 ,192 ,238),new Color(255, 185, 15),new Color(255, 127, 80),new Color(0, 178, 238),new Color(144 ,238 ,144)};
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2.0f));
		g2.setFont(new Font("宋体", Font.BOLD, 600));
		int width = WIDTH +10;
		int height = HEIGHT+10;
		for (int i = 0; i < 13; i++) {
			g2.setColor(colors[new Random().nextInt(2)]);
			int x1 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);

			int x2 = new Random().nextInt(width);
			int y2 = new Random().nextInt(height);
			g2.drawLine(x1, y1, x2, y2);
		}
	}

	private static void setBorder(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(255, 255, 255));
		g.drawRect(0, 0, WIDTH, HEIGHT);
	}
	

	private static void setBackGround(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(255, 255, 255));
		g.fillRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}
}
