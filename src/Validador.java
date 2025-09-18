public class Validador {

    public static boolean validarCPF(String cpf) {

        //verifica se o cpf é vazio
        if (cpf == null || cpf.trim().isEmpty()) return false;

        //"Limpa"o cpf e guarda na var limpo
        String limpo = cpf.trim().replaceAll("[.-]", "");

        //Se o cpf não tem 11 digitos retorne falso
        if (!limpo.matches("\\d{11}")) return false;

        //Se o cpf tem repetição de numeros retorna falsa
        if (limpo.chars().distinct().count() == 1) return false;
        //calcula o dv
        return checarDigitos(limpo);
    }

    private static boolean checarDigitos(String cpf) {
        int[] d = cpf.chars().map(c -> c - '0').toArray();
        // calcula DV1
        int s1 = 0;
        for (int i = 0; i < 9; i++) s1 += d[i] * (10 - i);
        int r1 = s1 % 11;
        int dv1 = (r1 < 2) ? 0 : 11 - r1;
        if (d[9] != dv1) return false;
        // calcula DV2
        int s2 = 0;
        for (int i = 0; i < 10; i++) s2 += d[i] * (11 - i);
        int r2 = s2 % 11;
        int dv2 = (r2 < 2) ? 0 : 11 - r2;
        return d[10] == dv2;
    }
}

