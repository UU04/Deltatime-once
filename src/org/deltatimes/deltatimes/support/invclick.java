package org.deltatimes.deltatimes.support;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.deltatimes.deltatimes.main;
import org.deltatimes.deltatimes.voids;

public class invclick implements Listener {
	// if(e.getWhoClicked().getOpenInventory().getTitle()) = "*무주서버 전용 GUI*"

	@EventHandler
	public void onMenuClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null)
			return;
		if (e.getCurrentItem().getData() == null)
			return;
		if (e.getCurrentItem().getItemMeta() == null)
			return;
		if (e.getCurrentItem().getType() == null)
			return;

		Player p = (Player) e.getWhoClicked();
		ItemStack it = e.getCurrentItem();

		if (it == null)
			return;
		if (e.getWhoClicked().getOpenInventory().getTitle().contains("#3159#")) {// 닉네임 변경 관련 f(x)
			e.setCancelled(true);
			if (it.getItemMeta().getDisplayName().contains("*닉네임 변경하기*")) {
				p.sendMessage(ChatColor.GREEN + "-------------------------------");
				p.sendMessage(ChatColor.YELLOW + "/nick <닉네임> 으로 닉네임을 설정해 주세요!");
				p.sendMessage(ChatColor.GREEN + "-------------------------------");
				p.sendMessage(ChatColor.GRAY + "(욕설, 비속어 포함 시 운영진 검토 후에 닉네임이 초기화 됩니다.)");
				p.sendMessage(ChatColor.GRAY + "(위의 상황에는, 닉네임 변경권을 지급하지 않습니다!)");
				org.deltatimes.deltatimes.main.wnick.put(p.getUniqueId(), "true");
				p.closeInventory();
			}
		}
		if (e.getWhoClicked().getOpenInventory().getTitle().contains("#2284#")) {// 개인 설정 관련
			e.setCancelled(true);

			if (it.getItemMeta().getDisplayName() == null)
				return;

			if (it.getItemMeta().getDisplayName().contains("채팅 서버 설정")) {

				voids.chatsett(Bukkit.getPlayer(e.getWhoClicked().getName()));
			}
			if (it.getItemMeta().getDisplayName().contains("채팅 검열 : ")) {
				int a;
				if (main.chatdvl.get(p.getUniqueId()) < 3) {
					a = main.chatdvl.get(p.getUniqueId()) + 1;
				} else {
					a = 0;
				}

				main.chatdvl.put(p.getUniqueId(), a);
				voids.chatsett(Bukkit.getPlayer(e.getWhoClicked().getName()));
			}
			if (it.getItemMeta().getDisplayName().contains("특수 효과 : ")) {
				int a;
				if (main.sfxlvl.get(p.getUniqueId()) < 3) {
					a = main.sfxlvl.get(p.getUniqueId()) + 1;
				} else {
					a = 0;
				}

				main.sfxlvl.put(p.getUniqueId(), a);
				voids.contents(Bukkit.getPlayer(e.getWhoClicked().getName()));
			}
			if (it.getItemMeta().getDisplayName().contains("GUI 및 컨텐츠 설정")) {
				// 게임 내 혈흔(피) 노출 여부
				//

				voids.contents(p);
			}
			if (it.getItemMeta().getDisplayName().contains("추가 컨텐츠(DLC) 설정")) {
				p.closeInventory();
			}
		} else {
			return;
		}
	}
}
