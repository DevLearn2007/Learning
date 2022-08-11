import java.applet.*;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.*;
//<applet code="demotest" width=300 height=300></applet>

public class demotest extends Applet implements ActionListener {
	String msg = "";
	TextField first, second, ans;
	Button addi, sub, mul, divi, clear;

	public static void main(String[] args) {
		new demotest().init();
	}
	
	
	public void init() {
		System.out.println("Hi");
		Label firstp = new Label("Enter the first value");
		Label secondp = new Label("Enter the second value");
		Label answer = new Label("Result");
		first = new TextField(8);
		second = new TextField(8);
		ans = new TextField(12);
		add(firstp);
		add(first);
		add(secondp);
		add(second);
		add(answer);
		add(ans);
		addi = new Button("Addi");
		sub = new Button("Sub");
		mul = new Button("mul");
		divi = new Button("Divi");
		clear = new Button("Clear");
		add(addi);
		add(sub);
		add(mul);
		add(divi);
		add(clear);
		addi.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		divi.addActionListener(this);
		clear.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		int a, b, c;
		a = Integer.parseInt(first.getText());
		b = Integer.parseInt(second.getText());
		String s = ae.getActionCommand();
		if (s.equals("Addi")) {
			c = a + b;
			ans.setText(String.valueOf(c));
		} else if (s.equals("Sub")) {
			c = a - b;
			ans.setText(String.valueOf(c));
		} else if (s.equals("Mul")) {
			c = a * b;
			ans.setText(String.valueOf(c));
		} else if (s.equals("Divi")) {
			c = a / b;
			ans.setText(String.valueOf(c));
		} else if (s.equals("Clear")) {
			first.setText("");
			second.setText("");
			ans.setText("");
		}
	}
}