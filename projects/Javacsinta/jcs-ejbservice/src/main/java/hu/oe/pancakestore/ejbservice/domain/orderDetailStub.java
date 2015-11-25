package hu.oe.pancakestore.ejbservice.domain;

public class orderDetailStub {

		private PancakeStub pancake;

		private int month;

		private long sumAmount;

		public orderDetailStub(PancakeStub pancake, int month, long sumAmount) {
			super();
			this.pancake = pancake;
			this.month = month;
			this.sumAmount = sumAmount;
		}

		public PancakeStub getPancake() {
			return pancake;
		}

		public int getMonth() {
			return month;
		}

		public long getSumAmount() {
			return sumAmount;
		}

		

		@Override
		public String toString() {
			return "orderDetailResult [pancake=" + pancake + ", month=" + month + ", sumAmount=" + sumAmount + "]";
		}

}

