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
			System.out.println("TV 전원 ON");
		}
		this.power = on;
	}

	public void channel(int channel) {
		if (channel <= 255 & channel >= 1) {
			this.channel = channel;
		} else {
			System.out.println("없는 채널입니다.");
		}
	}

	public void channel(boolean up) {
		if (channel < 255 & channel > 1) {
			if (up) {
				channel++;
			} else {
				channel--;
			}
		} else if ((channel == 255 & up) | (channel == 1 & !up)) {
			System.out.println("없는 채널입니다.");
		}
	}

	public void volume(int volume) {
		if (volume <= 100 & volume >= 0) {
			this.volume = volume;
		} else {
			System.out.println("잘못된 입력입니다.");
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
			System.out.println("현재 볼륨은 " + getVolume() + "이고, 현재 채널은 " + getChannel() + "번입니다.");
		} else {
			System.out.println("TV 전원 OFF");
		}
	}
}
