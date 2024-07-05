import request from '@/utils/request'

// 查询购票列表
export function listTicket_buy(query) {
  return request({
    url: '/system/ticket_buy/list',
    method: 'get',
    params: query
  })
}

// 查询购票详细
export function getTicket_buy(scenicId) {
  return request({
    url: '/system/ticket_buy/' + scenicId,
    method: 'get'
  })
}

// 新增购票
export function addTicket_buy(data) {
  return request({
    url: '/system/ticket_buy',
    method: 'post',
    data: data
  })
}

// 修改购票
export function updateTicket_buy(data) {
  return request({
    url: '/system/ticket_buy',
    method: 'put',
    data: data
  })
}

// 删除购票
export function delTicket_buy(scenicId) {
  return request({
    url: '/system/ticket_buy/' + scenicId,
    method: 'delete'
  })
}
