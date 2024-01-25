import java.util.*;
import java.io.*;

public class B_3425 {

	static final int MAX_STACK_SIZE = 1001;
	static final int MAX_VALUE = 1000000000;
	static ArrayList<Integer> comm;
	static ArrayList<Integer> numArr;
	static long[] stack = new long[MAX_STACK_SIZE];
	static int pt = 0;
	static boolean isQuit = false;
	static boolean isError;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			init();
			while (true) {
				String s = br.readLine();
				if (s.equals("QUIT")) {
					isQuit = true;
					break;
				} else if (s.equals("END")) {
					break;
				}
				String[] inStrList = s.split(" ");
				s = inStrList[0];
				if (s.equals("NUM")) {
					comm.add(1);
					int x = Integer.parseInt(inStrList[1]);
					numArr.add(x);
				} else if (s.equals("POP")) {
					comm.add(2);
				} else if (s.equals("INV")) {
					comm.add(3);
				} else if (s.equals("DUP")) {
					comm.add(4);
				} else if (s.equals("SWP")) {
					comm.add(5);
				} else if (s.equals("ADD")) {
					comm.add(6);
				} else if (s.equals("SUB")) {
					comm.add(7);
				} else if (s.equals("MUL")) {
					comm.add(8);
				} else if (s.equals("DIV")) {
					comm.add(9);
				} else if (s.equals("MOD")) {
					comm.add(10);
				}
			}
			if (isQuit) {
				System.out.println(answer);
				break;
			}
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				pt = 0;
				isError = false;
				long num = Long.parseLong(br.readLine());
				stack[pt++] = num;
				solve();
			}
			answer.append("\n");
		}
		br.close();
	}

	private static void solve() {
		int numIdx = 0;
		for (int command : comm) {
			if (isError) break;
			if (command == 1) {
				num(numArr.get(numIdx++));
			} else if (command == 2) {
				if (pt == 0) {
					isError = true;
					break;
				}
				pop();
			} else if (command == 3) {
				inv();
			} else if (command == 4) {
				if (pt == 0) {
					isError = true;
					break;
				}
				dup();
			} else if (command == 5) {
				if (pt <= 1) {
					isError = true;
					break;
				}
				swp();
			} else if (command == 6) {
				if (pt <= 1) {
					isError = true;
					break;
				}
				add();
			} else if (command == 7) {
				if (pt <= 1) {
					isError = true;
					break;
				}
				sub();
			} else if (command == 8) {
				if (pt <= 1) {
					isError = true;
					break;
				}
				mul();
			} else if (command == 9) {
				if (pt <= 1) {
					isError = true;
					break;
				}
				div();
			} else if (command == 10) {
				if (pt <= 1) {
					isError = true;
					break;
				}
				mod();
			}
		}
		
		if (isError || pt != 1) {
			answer.append("ERROR\n");
		} else {
			answer.append(stack[0]).append("\n");
		}
	}
	
	private static void num(long n) {
		stack[pt++] = n;
	}
	
	private static void pop() {
		pt--;
	}
	
	private static void inv() {
		stack[pt - 1] = -stack[pt - 1];
	}
	
	private static void dup() {
		stack[pt] = stack[pt-1];
		pt++;
	}
	
	private static void swp() {
		long tmp = stack[pt - 1];
		stack[pt - 1] = stack[pt - 2];
		stack[pt - 2] = tmp;
	}
	
	private static void add() {
		long tmp = stack[pt - 1] + stack[pt - 2];
		if (Math.abs(tmp) > MAX_VALUE) {
			isError = true;
			return;
		}
		stack[pt - 2] = tmp;
		pt--;
	}
	
	private static void sub() {
		long tmp = stack[pt - 2] - stack[pt - 1];
		if (Math.abs(tmp) > MAX_VALUE) {
			isError = true;
			return;
		}
		stack[pt - 2] = tmp;
		pt--;
	}
	
	private static void mul() {
		long tmp = stack[pt - 2] * stack[pt - 1];
		if (Math.abs(tmp) > MAX_VALUE) {
			isError = true;
			return;
		}
		stack[pt - 2] = tmp;
		pt--;
	}
	
	private static void div() {
		long tmp1, tmp2;
		int tFlag = 0;
		if (stack[pt - 1] == 0) {
			isError = true;
			return;
		}
		tmp1 = stack[pt - 2];
		tmp2 = stack[pt - 1];
		if (tmp1 < 0) tFlag++;
		if (tmp2 < 0) tFlag++;
		tmp1 = Math.abs(tmp1) / Math.abs(tmp2);
		if (tFlag == 1) stack[pt - 2] = -tmp1;
		else stack[pt - 2] = tmp1;
		pt--;
	}
	
	private static void mod() {
		long tmp;
		if (stack[pt - 1] == 0) {
			isError = true;
			return;
		}
		tmp = Math.abs(stack[pt - 2]) % Math.abs(stack[pt - 1]);
		if (stack[pt - 2] < 0) stack[pt - 2] = -tmp;
		else stack[pt - 2] = tmp;
		pt--;
	}

	private static void init() {
		comm = new ArrayList<>();
		numArr = new ArrayList<>();
		pt = 0;
	}
}
