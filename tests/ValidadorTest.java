import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorTest {

    @Test
    void deveValidarCPFValido() {
        //CPFs validos deve passar
        assertTrue(Validador.validarCPF("529.982.247-25"));
        assertTrue(Validador.validarCPF("52998224725"));
    }

    @Test
    //Faz o teste dos IFs da função, vazio, "", letras, e repetições
    void deveRejeitarEntradasInvalidas() {
        assertFalse(Validador.validarCPF(null));
        assertFalse(Validador.validarCPF(""));
        assertFalse(Validador.validarCPF("529.982.247-2X"));
        assertFalse(Validador.validarCPF("00000000000"));
    }
    @Test
    //Retorna falso pois os tamanhos verificados nos IFs nao batem 11 digitos
    void deveRejeitarTamanhosIncorretos() {
        assertFalse(Validador.validarCPF("935.411.347-8"));   // 10 dígitos
        assertFalse(Validador.validarCPF("935.411.347-800")); // 12 dígitos
    }

    @Test
    //Funcao calculaDv entra e retorna false, pois os DV são inválidos
    void deveRejeitarDVIncorreto() {
        assertFalse(Validador.validarCPF("529.982.247-24"));
        assertFalse(Validador.validarCPF("123.456.789-00"));
    }
}
