package tv;

public class TV {
	private int volume;
	private int channel;
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public void isPower(boolean on) {
		if (on) {
			System.out.println("ON");
		}
		this.power = on;
	}

	// 1~255
	public void channel(int channel) {
		if (channel <= 255 & channel >= 1) {
			this.channel = channel;
		} else {
			System.out.println("없는 채널입니다. 현재 채널을 유지합니다.");
		}
	}

	// 1일 때 !up이면 255 return
	// 255일 때 up이면 0 return
	public void channel(boolean up) {
		if (channel < 255 & channel > 1) {
			if (up) {
				channel++;
			} else {
				channel--;
			}
		} else if (channel == 255 & up) {
			channel = 0;
		} else if (channel == 1 & !up) {
			channel = 255;
		}
	}

	public void volume(int volume) {
		if (volume <= 100 & volume >= 0) {
			this.volume = volume;
		} else {
			System.out.println("올바른 볼륨 값을 입력하세요.");
		}
	}

	public void volume(boolean up) {
		if (volume < 100 & volume > 0) {
			if (up) {
				volume++;
			} else {
				volume--;
			}
		} else if (volume == 100 & up) {
			System.out.println("현재 최대 볼륨입니다.");
		} else if (volume == 0 & !up) {
			System.out.println("현재 최소 볼륨입니다.");
		}
	}

	public void status() {
		if (power) {
			System.out.println("## " + "Volume= " + getVolume() + ", Channel=" + getChannel() + " ##");
		} else {
			System.out.println("OFF");
		}
	}

	public void hi() {
		System.out.println(" _______  _______  ___      _______  __   __  ___   _______  ___   _______  __    _ \r\n"
						 + "|       ||       ||   |    |       ||  | |  ||   | |       ||   | |       ||  |  | |\r\n"
						 + "|_     _||    ___||   |    |    ___||  |_|  ||   | |  _____||   | |   _   ||   |_| |\r\n"
						 + "  |   |  |   |___ |   |    |   |___ |       ||   | | |_____ |   | |  | |  ||       |\r\n"
						 + "  |   |  |    ___||   |___ |    ___||       ||   | |_____  ||   | |  |_|  ||  _    |\r\n"
						 + "  |   |  |   |___ |       ||   |___  |     | |   |  _____| ||   | |       || | |   |\r\n"
						 + "  |___|  |_______||_______||_______|  |___|  |___| |_______||___| |_______||_|  |__|");
	}
}
