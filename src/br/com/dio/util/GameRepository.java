package br.com.dio.util;
import java.util.*;
import br.com.dio.model.Space;


/**
 * Sobre a classe Game Repository:
 * 
 * Essa classe fica responsável por guardar as informações do tabuleiro
 * dessa forma não é mais necessário carregar essa informação no running arguments.
 * 
 * A ideia é trazer escalabilidade pro projeto.
 * 
 * É o início do caminho para trazer melhorias 
 * futuras, fazendo o programa consumir um serviço, 
 * um banco de dados ou uma lib como Gson para novas
 * configurações de jogo. 
 * 
 * No caso do Gson, será necessário mudar a implementação 
 * para que o jogo leia JSON.
 * 
 * 
 */


public class GameRepository {

    private static final List<String> games = new ArrayList<>();
    private static int sequentialIndex = 0;

    static {
        // ===================== JOGO 1 =====================
        // Solução: 
        // 4 7 9 5 8 6 2 3 1
        // 1 3 5 4 7 2 8 9 6
        // 2 6 8 9 1 3 7 4 5
        // 5 1 3 7 6 4 9 8 2
        // 8 9 7 1 2 5 3 6 4
        // 6 4 2 3 9 8 1 5 7
        // 7 5 4 2 3 9 6 1 8
        // 9 8 1 6 4 7 5 2 3
        // 3 2 6 8 5 1 4 7 9
        games.add(
            "0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false " +
            "0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true " +
            "0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true " +
            "0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false " +
            "0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false " +
            "0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true " +
            "0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false " +
            "0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false " +
            "0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false"
        );

        // ===================== JOGO 2 =====================
        // Solução:
        // 1 2 3 4 5 6 7 8 9
        // 4 5 6 7 8 9 1 2 3
        // 7 8 9 1 2 3 4 5 6
        // 2 3 1 5 6 4 8 9 7
        // 5 6 4 8 9 7 2 3 1
        // 8 9 7 2 3 1 5 6 4
        // 3 1 2 6 4 5 9 7 8
        // 6 4 5 9 7 8 3 1 2
        // 9 7 8 3 1 2 6 4 5
        games.add(
            "0,0;1,false 1,0;2,false 2,0;3,false 3,0;4,false 4,0;5,false 5,0;6,false 7,0;8,false 8,0;9,false " +
            "0,1;4,false 1,1;5,false 2,1;6,false 3,1;7,false 4,1;8,false 5,1;9,false 6,1;1,false 7,1;2,false 8,1;3,false " +
            "0,2;7,false 1,2;8,false 2,2;9,false 3,2;1,false 4,2;2,false 5,2;3,false 6,2;4,false 7,2;5,false 8,2;6,false " +
            "0,3;2,false 1,3;3,false 2,3;1,false 3,3;5,false 4,3;6,false 5,3;4,false 6,3;8,false 7,3;9,false 8,3;7,false " +
            "0,4;5,false 1,4;6,false 2,4;4,false 3,4;8,false 4,4;9,false 5,4;7,false 6,4;2,false 7,4;3,false 8,4;1,false " +
            "0,5;8,false 1,5;9,false 2,5;7,false 3,5;2,false 4,5;3,false 5,5;1,false 6,5;5,false 7,5;6,false 8,5;4,false " +
            "0,6;3,false 1,6;1,false 2,6;2,false 3,6;6,false 4,6;4,false 5,6;5,false 6,6;9,false 7,6;7,false 8,6;8,false " +
            "0,7;6,false 1,7;4,false 2,7;5,false 3,7;9,false 4,7;7,false 5,7;8,false 6,7;3,false 7,7;1,false 8,7;2,false " +
            "0,8;9,false 1,8;7,false 2,8;8,false 3,8;3,false 4,8;1,false 5,8;2,false 6,8;6,false 7,8;4,false 8,8;5,false"
        );


    }

    // Retorna um jogo aleatório
    public static String getRandom() {
        var jogo = new Random();
        return games.get(jogo.nextInt(games.size()));
    }

    // Retorna o próximo jogo sequencial
    public static String getNextSequential() {
        var game = games.get(sequentialIndex);
        sequentialIndex = (sequentialIndex + 1) % games.size();
        return game;
    }

    // Retorna o Map pronto, parseado, para uso direto na Main
    public static Map<String, Space> getParsedGameRandom() {
        String gameStr = getRandom();
        return parseGameString(gameStr);
    }

    public static Map<String, Space> getParsedGameSequential() {
        String gameStr = getNextSequential();
        return parseGameString(gameStr);
    }

    private static Map<String, Space> parseGameString(String boardString) {
        Map<String, Space> map = new HashMap<>();
        for (String entry : boardString.split(" ")) {
            String[] parts = entry.split(";");
            String posKey = parts[0];
            String[] valueAndFixed = parts[1].split(",");
            int expected = Integer.parseInt(valueAndFixed[0]);
            boolean fixed = Boolean.parseBoolean(valueAndFixed[1]);
            map.put(posKey, new Space(expected, fixed));
        }
        return map;
    }
}