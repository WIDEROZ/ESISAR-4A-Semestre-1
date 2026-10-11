----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 09.10.2026 10:29:52
-- Design Name: 
-- Module Name: red_moore - Behavioral
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

entity red_moore is
    Port ( clk : in STD_LOGIC;
           rst : in STD_LOGIC;
           red_in : in STD_LOGIC;
           red_out : out STD_LOGIC);
end red_moore;

architecture Behavioral of red_moore is

type state_type is (s0, s1, s2);

signal state : state_type := s0;
signal next_state : state_type := s0;

begin

process(clk, rst)
begin
    if (rst = '1') then
        state <= s0;
    else
        if (clk'event AND clk = '1') then
           state <= next_state;
        end if; 
    end if;
end process;



process(state, red_in)
begin
    next_state <= s0;
    red_out <= '0';
    case state is
        WHEN s0 =>
            if(red_in = '1') then
                next_state <= s1;
            end if;
        WHEN s1 =>
            red_out <= '1';
            if (red_in = '0') then
                next_state <= s0;
            else
                next_state <= s2;
            end if;
        WHEN s2 =>
            if (red_in = '0') then
                next_state <= s0;
            end if;
     end case;
end process;



end Behavioral;
