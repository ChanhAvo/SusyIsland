package Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    boolean checkDrawTime = false;
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 2){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    gp.sound.stop();
                    gp.playMusic(1);
                }
                if(gp.ui.commandNum == 1){
                    System.exit(0);
                }
            }
        }

        //PLAY STATE
        if(gp.gameState == gp.playState){
            if(code == KeyEvent.VK_W){
                upPressed = true;
            }
            if(code == KeyEvent.VK_S){
                downPressed = true;
            }
            if(code == KeyEvent.VK_A){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_D){
                rightPressed = true;
            }
            if(code == KeyEvent.VK_P){
                gp.gameState = gp.pauseState;
            }
            if(code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
            if (code == KeyEvent.VK_C){
                gp.gameState = gp.characterState;
            }
            if (code == KeyEvent.VK_E) {
                gp.gameState = gp.inventoryState;
            }
        }
        //PAUSE STATE
        else if(gp.gameState == gp.pauseState){
            if(code == KeyEvent.VK_P){
                gp.gameState = gp.playState;
            }
        }
        else if(gp.gameState == gp.gameOverState){
            gameOverState(code);
        }
        //DIALOGUE STATE
        else if(gp.gameState == gp.dialogueState){
            if(code == KeyEvent.VK_ENTER){
                gp.gameState = gp.playState;
            }
        }
        //CHARACTER STATE
        else if(gp.gameState == gp.characterState){
            if(code == KeyEvent.VK_C){
                gp.gameState = gp.playState;
            }

        }
        //INVENTORY
        else if(gp.gameState == gp.inventoryState){
            playerInventory(code);
        }
        //TRADE STATE
        else if(gp.gameState == gp.tradeState){
            if(code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
            if(gp.ui.subState == 0){
                if(code == KeyEvent.VK_W){
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
                }
                if(code == KeyEvent.VK_S){
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
                }
            }
            if(gp.ui.subState == 1){
                npcInventory(code);
                if(code == KeyEvent.VK_ESCAPE){
                    gp.ui.subState = 0;
                }
            }
            if(gp.ui.subState == 2){
                playerInventory(code);
                if(code == KeyEvent.VK_ESCAPE){
                    gp.ui.subState = 0;
                }
            }
        }
    }
    public void npcInventory(int code){
        if(code == KeyEvent.VK_W){
            if(gp.ui.npcSlotRow != 0 ){
                gp.ui.npcSlotRow--;
            }

        }
        if(code == KeyEvent.VK_A){
            if(gp.ui.npcSlotCol != 0){
                gp.ui.npcSlotCol--;
            }
        }
        if(code == KeyEvent.VK_S){
            if(gp.ui.npcSlotRow != 3){
                gp.ui.npcSlotRow++;
            }

        }
        if(code == KeyEvent.VK_D){
            if(gp.ui.npcSlotCol != 4){
                gp.ui.npcSlotCol++;
            }
        }
    }
    public void playerInventory(int code){
        if(code == KeyEvent.VK_E){
            gp.gameState = gp.playState;
        }
        if(code == KeyEvent.VK_W){
            if(gp.ui.playerSlotRow != 0 ){
                gp.ui.playerSlotRow--;
            }

        }
        if(code == KeyEvent.VK_A){
            if(gp.ui.playerSlotCol != 0){
                gp.ui.playerSlotCol--;
            }
        }
        if(code == KeyEvent.VK_S){
            if(gp.ui.playerSlotRow != 3){
                gp.ui.playerSlotRow++;
            }

        }
        if(code == KeyEvent.VK_D){
            if(gp.ui.playerSlotCol != 4){
                gp.ui.playerSlotCol++;
            }
        }
        if(code == KeyEvent.VK_N){
            gp.player.selectItem();
//            if(selectedItem.type == type_consumable){
//                gp.player.life = gp.player.maxLife;

        }
    }
    public void gameOverState(int code) {
        if(code == KeyEvent.VK_W){
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0 ){
                gp.ui.commandNum = 1;
            }
            gp.playSE(6);
        }
        if(code == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 0) {
                gp.ui.commandNum = 1;
            }
            gp.playSE(6);
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum ==0){
                gp.gameState = gp.playState;
                gp.retry();
            }
            else if(gp.ui.commandNum == 1){
                gp.gameState = gp.titleState;
                gp.restart();
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}