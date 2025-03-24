package br.com.devdojo.varargs.nio;

public class SysemExamples {
        public static void main(String[] args) {
                    // Propriedades do Sistema Operacional
                    System.out.println("Nome do Sistema Operacional: " + System.getProperty("os.name"));
                    System.out.println("Versão do Sistema Operacional: " + System.getProperty("os.version"));
                    System.out.println("Arquitetura do Sistema Operacional: " + System.getProperty("os.arch"));

                    // Propriedades do Usuário
                    System.out.println("Nome do Usuário: " + System.getProperty("user.name"));
                    System.out.println("Diretório Home do Usuário: " + System.getProperty("user.home"));
                    System.out.println("Diretório de Trabalho Atual: " + System.getProperty("user.dir"));
                    System.out.println("Idioma do Usuário: " + System.getProperty("user.language"));
                    System.out.println("Região do Usuário: " + System.getProperty("user.region"));

                    // Propriedades do Java Runtime
                    System.out.println("Versão do Java: " + System.getProperty("java.version"));
                    System.out.println("Diretório do Java Home: " + System.getProperty("java.home"));
                    System.out.println("Fornecedor do Java: " + System.getProperty("java.vendor"));
                    System.out.println("URL do Fornecedor do Java: " + System.getProperty("java.vendor.url"));
                    System.out.println("Nome da Especificação do Java: " + System.getProperty("java.specification.name"));
                    System.out.println("Versão da Especificação do Java: " + System.getProperty("java.specification.version"));
                    System.out.println("Fornecedor da Especificação do Java: " + System.getProperty("java.specification.vendor"));
                    System.out.println("Nome da JVM: " + System.getProperty("java.vm.name"));
                    System.out.println("Versão da JVM: " + System.getProperty("java.vm.version"));
                    System.out.println("Fornecedor da JVM: " + System.getProperty("java.vm.vendor"));
                    System.out.println("Caminho da Biblioteca Java: " + System.getProperty("java.library.path"));

                    // Informações de Tempo de Execução
                    Runtime runtime = Runtime.getRuntime();
                    System.out.println("Número de Processadores Disponíveis: " + runtime.availableProcessors());
                    System.out.println("Memória Máxima (bytes): " + runtime.maxMemory());
                    System.out.println("Memória Total (bytes): " + runtime.totalMemory());
                    System.out.println("Memória Livre (bytes): " + runtime.freeMemory());
                }
            }


