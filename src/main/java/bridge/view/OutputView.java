package bridge.view;

import bridge.domain.Board;

import java.util.List;

public class OutputView {
    public static void print(String text) {
        System.out.println(text);
    }

    public static void printWithLineSpace(String text) {
        System.out.print(System.lineSeparator());
        print(text);
    }

    public static void instructionStart() {
        print("다리 건너기 게임을 시작합니다.");
    }

    public static void getLength() {
        printWithLineSpace("다리의 길이를 입력해주세요.");
    }

    public static void getMove() {
        printWithLineSpace("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void getContinue() {
        printWithLineSpace("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void displayTurnResult(List<List<Board>> bridges) {
        for (List<Board> bridge : bridges) {
            bridgeResult(bridge);
        }
    }

    private void bridgeResult(List<Board> bridge) {
        String[] result = bridge.stream().map(board -> {
            if (board.getSelected()) {
                if (board.getPassable()) {
                    return " O ";
                }
                return " X ";
            }
            return "   ";
        }).toArray(String[]::new);

        print("[" + String.join("|", result) + "]");
    }

    public void displayFinalResult(List<List<Board>> bridges, boolean successful, int tryCount) {
        printWithLineSpace("최종 게임 결과");
        displayTurnResult(bridges);
        successfulResult(successful);
        print(String.format("총 시도한 횟수: %d", tryCount));
    }

    private void successfulResult(boolean successful) {
        if (successful) {
            printWithLineSpace("게임 성공 여부: 성공");
        }
        if (!successful) {
            printWithLineSpace("게임 성공 여부: 실패");
        }
    }
}
