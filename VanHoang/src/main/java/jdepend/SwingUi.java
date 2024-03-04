package jdepend;

import java.io.IOException;

import jdepend.swingui.JDepend;

public class SwingUi {
	public static void main(String[] args) throws IOException {
		JDepend jdpSwing = new JDepend();
		jdpSwing.addDirectory("T:\\VanHoang\\Library-Assistant");
		jdpSwing.analyze();
		System.out.println("DONE");
	}
}
