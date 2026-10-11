----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 09.10.2026 08:44:35
-- Design Name: 
-- Module Name: FlipFlop - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity FlipFlop is
    Port ( D : in STD_LOGIC;
           clk : in STD_LOGIC;
           rst : in STD_LOGIC;
           Q : out STD_LOGIC);
end FlipFlop;

architecture Behavioral of FlipFlop is

begin


process(clk, rst)
begin
    if (rst = '1') then
        Q <= '0';
    else 
        if (clk'event AND clk = '1') then
            Q <= D;
        end if;
    end if;
end process;

end Behavioral;
